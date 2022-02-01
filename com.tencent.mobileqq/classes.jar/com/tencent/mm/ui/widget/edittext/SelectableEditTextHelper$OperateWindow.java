package com.tencent.mm.ui.widget.edittext;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.Layout;
import android.text.Selection;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.tencent.mm.ui.f;
import com.tencent.mm.ui.g;
import com.tencent.mm.ui.widget.textview.TextLayoutUtil;
import com.tencent.mobileqq.qmethodmonitor.monitor.ClipboardMonitor;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class SelectableEditTextHelper$OperateWindow
{
  RecyclerView a;
  SelectableEditTextHelper.MyRecycleViewAdapter b;
  List<SelectableEditTextHelper.MenuItem> c;
  ImageView d;
  private PopupWindow f;
  private int g;
  private int h;
  
  public SelectableEditTextHelper$OperateWindow(SelectableEditTextHelper paramSelectableEditTextHelper, Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131625221, null);
    paramContext.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    this.g = paramContext.getMeasuredWidth();
    this.h = paramContext.getMeasuredHeight();
    this.f = new PopupWindow(paramContext, -2, -2, false);
    this.f.setClippingEnabled(false);
    this.a = ((RecyclerView)paramContext.findViewById(2131445211));
    Object localObject = new LinearLayoutManager(SelectableEditTextHelper.x(paramSelectableEditTextHelper), 0, false);
    this.a.setLayoutManager((RecyclerView.LayoutManager)localObject);
    this.c = a();
    this.b = new SelectableEditTextHelper.MyRecycleViewAdapter(this.c, new SelectableEditTextHelper.OperateWindow.1(this, paramSelectableEditTextHelper), SelectableEditTextHelper.y(paramSelectableEditTextHelper));
    this.a.setAdapter(this.b);
    localObject = new DividerItemDecoration(SelectableEditTextHelper.x(paramSelectableEditTextHelper), 0);
    ((DividerItemDecoration)localObject).setDrawable(new ColorDrawable(SelectableEditTextHelper.x(paramSelectableEditTextHelper).getResources().getColor(2131166319)));
    this.a.addItemDecoration((RecyclerView.ItemDecoration)localObject);
    this.d = ((ImageView)paramContext.findViewById(2131431535));
  }
  
  private List<SelectableEditTextHelper.MenuItem> a()
  {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(new SelectableEditTextHelper.MenuItem(SelectableEditTextHelper.x(this.e).getResources().getString(2131891527), 1, 4));
    localLinkedList.add(new SelectableEditTextHelper.MenuItem(SelectableEditTextHelper.x(this.e).getResources().getString(17039373), 16908319, 12));
    localLinkedList.add(new SelectableEditTextHelper.MenuItem(SelectableEditTextHelper.x(this.e).getResources().getString(17039363), 16908320, 9));
    localLinkedList.add(new SelectableEditTextHelper.MenuItem(SelectableEditTextHelper.x(this.e).getResources().getString(17039361), 16908321, 9));
    localLinkedList.add(new SelectableEditTextHelper.MenuItem(SelectableEditTextHelper.x(this.e).getResources().getString(17039371), 16908322));
    return localLinkedList;
  }
  
  private void a(View paramView, SelectableEditTextHelper.MenuItem paramMenuItem, String paramString)
  {
    int i = paramMenuItem.id;
    Object localObject;
    if (i != 1)
    {
      ClipData localClipData;
      switch (i)
      {
      default: 
        SelectableEditTextHelper.k(this.e).setCursorVisible(true);
        break;
      case 16908322: 
        SelectableEditTextHelper.k(this.e).onTextContextMenuItem(16908322);
        SelectableEditTextHelper.k(this.e).setCursorVisible(true);
        localObject = this.e;
        SelectableEditTextHelper.d((SelectableEditTextHelper)localObject, SelectableEditTextHelper.k((SelectableEditTextHelper)localObject).getSelectionStart());
        break;
      case 16908321: 
        localObject = (ClipboardManager)SelectableEditTextHelper.x(this.e).getSystemService("clipboard");
        localClipData = ClipData.newPlainText(SelectableEditTextHelper.y(this.e).mSelectionContent, SelectableEditTextHelper.y(this.e).mSelectionContent);
        ClipboardMonitor.setPrimaryClip((ClipboardManager)localObject, localClipData);
        ((ClipboardManager)localObject).setPrimaryClip(localClipData);
        if (SelectableEditTextHelper.z(this.e) != null) {
          SelectableEditTextHelper.z(this.e).onTextSelected(SelectableEditTextHelper.y(this.e).mSelectionContent);
        }
        SelectableEditTextHelper.t(this.e);
        SelectableEditTextHelper.u(this.e);
        Toast.makeText(SelectableEditTextHelper.x(this.e), SelectableEditTextHelper.x(this.e).getResources().getString(2131891524), 0).show();
        SelectableEditTextHelper.k(this.e).setCursorVisible(true);
        Selection.setSelection(SelectableEditTextHelper.k(this.e).getEditableText(), SelectableEditTextHelper.k(this.e).getSelectionEnd());
        break;
      case 16908320: 
        localObject = (ClipboardManager)SelectableEditTextHelper.x(this.e).getSystemService("clipboard");
        localClipData = ClipData.newPlainText(SelectableEditTextHelper.y(this.e).mSelectionContent, SelectableEditTextHelper.y(this.e).mSelectionContent);
        ClipboardMonitor.setPrimaryClip((ClipboardManager)localObject, localClipData);
        ((ClipboardManager)localObject).setPrimaryClip(localClipData);
        if (SelectableEditTextHelper.z(this.e) != null) {
          SelectableEditTextHelper.z(this.e).onTextSelected(SelectableEditTextHelper.y(this.e).mSelectionContent);
        }
        SelectableEditTextHelper.t(this.e);
        SelectableEditTextHelper.u(this.e);
        ((Editable)SelectableEditTextHelper.k(this.e).getText()).delete(SelectableEditTextHelper.y(this.e).mStart, SelectableEditTextHelper.y(this.e).mEnd);
        Toast.makeText(SelectableEditTextHelper.x(this.e), SelectableEditTextHelper.x(this.e).getResources().getString(2131891525), 0).show();
        SelectableEditTextHelper.k(this.e).setCursorVisible(true);
        break;
      case 16908319: 
        SelectableEditTextHelper.u(this.e);
        localObject = this.e;
        SelectableEditTextHelper.b((SelectableEditTextHelper)localObject, 0, SelectableEditTextHelper.k((SelectableEditTextHelper)localObject).getText().length());
        SelectableEditTextHelper.d(this.e, false);
        SelectableEditTextHelper.k(this.e).post(new SelectableEditTextHelper.OperateWindow.2(this));
        SelectableEditTextHelper.k(this.e).setCursorVisible(false);
        break;
      }
    }
    else
    {
      SelectableEditTextHelper.u(this.e);
      i = SelectableEditTextHelper.k(this.e).getSelectionStart();
      if (i > 0) {
        SelectableEditTextHelper.b(this.e, i - 1, i);
      } else {
        SelectableEditTextHelper.b(this.e, i, i + 1);
      }
      SelectableEditTextHelper.d(this.e, false);
      localObject = this.e;
      SelectableEditTextHelper.b((SelectableEditTextHelper)localObject, SelectableEditTextHelper.o((SelectableEditTextHelper)localObject));
      localObject = this.e;
      SelectableEditTextHelper.b((SelectableEditTextHelper)localObject, SelectableEditTextHelper.p((SelectableEditTextHelper)localObject));
      localObject = this.e;
      SelectableEditTextHelper.b((SelectableEditTextHelper)localObject, SelectableEditTextHelper.n((SelectableEditTextHelper)localObject));
      SelectableEditTextHelper.k(this.e).setCursorVisible(false);
    }
    if (SelectableEditTextHelper.a().containsKey(Integer.valueOf(paramMenuItem.id)))
    {
      SelectableEditTextHelper.k(this.e).onTextContextMenuItem(paramMenuItem.id);
      SelectableEditTextHelper.t(this.e);
      SelectableEditTextHelper.u(this.e);
      SelectableEditTextHelper.k(this.e).setCursorVisible(true);
    }
    if (SelectableEditTextHelper.A(this.e) != null) {
      SelectableEditTextHelper.A(this.e).onMenuItemClicked(paramView, paramMenuItem, paramString);
    }
  }
  
  private void b()
  {
    int i = SelectableEditTextHelper.k(this.e).getText().length();
    if ((i > 0) && (SelectableEditTextHelper.y(this.e).mStart == 0) && (SelectableEditTextHelper.y(this.e).mEnd == i)) {
      i = 1;
    } else if (SelectableEditTextHelper.y(this.e).mStart == SelectableEditTextHelper.y(this.e).mEnd)
    {
      if (i > 0) {
        i = 4;
      } else {
        i = 2;
      }
    }
    else {
      i = 8;
    }
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.c.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (SelectableEditTextHelper.MenuItem)localIterator.next();
      if (((((SelectableEditTextHelper.MenuItem)localObject).id != 16908322) || (c())) && ((((SelectableEditTextHelper.MenuItem)localObject).visibleFlag & i) != 0)) {
        localLinkedList.add(localObject);
      }
    }
    if (SelectableEditTextHelper.a().size() > 0)
    {
      localIterator = SelectableEditTextHelper.a().entrySet().iterator();
      while (localIterator.hasNext())
      {
        localObject = (Map.Entry)localIterator.next();
        localLinkedList.add(new SelectableEditTextHelper.MenuItem(((CharSequence)((Map.Entry)localObject).getValue()).toString(), ((Integer)((Map.Entry)localObject).getKey()).intValue()));
      }
    }
    if (SelectableEditTextHelper.A(this.e) != null) {
      SelectableEditTextHelper.A(this.e).onMenuInit(localLinkedList, i);
    }
    SelectableEditTextHelper.MyRecycleViewAdapter.a(this.b, localLinkedList);
    this.b.notifyDataSetChanged();
  }
  
  private boolean c()
  {
    return true;
  }
  
  public void dismiss()
  {
    this.f.dismiss();
  }
  
  public boolean isShowing()
  {
    return this.f.isShowing();
  }
  
  public void show()
  {
    b();
    Object localObject = this.f.getContentView();
    ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    this.g = ((View)localObject).getMeasuredWidth();
    this.h = ((View)localObject).getMeasuredHeight();
    SelectableEditTextHelper.k(this.e).getLocationInWindow(SelectableEditTextHelper.v(this.e));
    localObject = SelectableEditTextHelper.k(this.e).getLayout();
    int i2 = TextLayoutUtil.getScreenWidth(SelectableEditTextHelper.x(this.e));
    int n = g.a(SelectableEditTextHelper.x(this.e), 10);
    int i = i2 - n * 2;
    if (this.g >= i) {
      this.g = i;
    }
    int j = ((int)((Layout)localObject).getPrimaryHorizontal(SelectableEditTextHelper.y(this.e).mStart) + (int)((Layout)localObject).getPrimaryHorizontal(SelectableEditTextHelper.y(this.e).mEnd)) / 2 + SelectableEditTextHelper.v(this.e)[0] - this.g / 2 + SelectableEditTextHelper.k(this.e).getPaddingLeft();
    i = j;
    if (SelectableEditTextHelper.y(this.e).mStart != SelectableEditTextHelper.y(this.e).mEnd)
    {
      i = j;
      if (((Layout)localObject).getLineForOffset(SelectableEditTextHelper.y(this.e).mStart) != ((Layout)localObject).getLineForOffset(SelectableEditTextHelper.y(this.e).mEnd)) {
        i = SelectableEditTextHelper.v(this.e)[0] + SelectableEditTextHelper.k(this.e).getWidth() / 2 - this.g / 2;
      }
    }
    int m = ((Layout)localObject).getLineTop(((Layout)localObject).getLineForOffset(SelectableEditTextHelper.y(this.e).mStart)) + SelectableEditTextHelper.v(this.e)[1] - this.h + SelectableEditTextHelper.k(this.e).getPaddingTop() - SelectableEditTextHelper.B(this.e) - g.a(SelectableEditTextHelper.x(this.e), 5);
    int i1 = SelectableEditTextHelper.v(this.e)[1] - this.h - g.a(SelectableEditTextHelper.x(this.e), 5);
    int i3 = SelectableEditTextHelper.v(this.e)[1];
    int i4 = SelectableEditTextHelper.k(this.e).getHeight();
    int i5 = this.h;
    int i6 = g.a(SelectableEditTextHelper.x(this.e), 5);
    if (i <= n) {
      j = n;
    } else {
      j = i;
    }
    int k = m;
    if (m < i1) {
      k = i1;
    }
    if (k > i3 + i4 - i5 - i6) {
      return;
    }
    i1 = this.g;
    m = j;
    if (j + i1 > i2) {
      m = i2 - i1 - n;
    }
    ((LinearLayout.LayoutParams)this.d.getLayoutParams()).leftMargin = (i - m);
    if (Build.VERSION.SDK_INT >= 21) {
      this.f.setElevation(8.0F);
    }
    localObject = this.a.getLayoutManager();
    if ((localObject instanceof LinearLayoutManager)) {
      ((LinearLayoutManager)localObject).scrollToPosition(0);
    }
    this.f.setWidth(this.g);
    try
    {
      this.f.showAtLocation(SelectableEditTextHelper.k(this.e), 0, m, k);
      return;
    }
    catch (Exception localException)
    {
      f.e("SelectableEditTextHelper", "oper error!:%s", new Object[] { localException.getMessage() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.edittext.SelectableEditTextHelper.OperateWindow
 * JD-Core Version:    0.7.0.1
 */