package com.tencent.av.wtogether.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.wtogether.adapter.GroupFileSearchExpandableListAdapter;
import com.tencent.av.wtogether.adapter.GroupFileSearchExpandableListAdapter.FileSelectListener;
import com.tencent.av.wtogether.data.ChooseFileInfo;
import com.tencent.av.wtogether.handler.WatchTogetherHandler;
import com.tencent.av.wtogether.observer.WatchTogetherObserver;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.ISearchable;
import com.tencent.mobileqq.search.SearchTask;
import com.tencent.mobileqq.search.SearchTask.SearchTaskCallBack;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.filemanager.data.TroopFileSearchItemData;
import com.tencent.mobileqq.troop.widget.CountdownTimeTask;
import com.tencent.mobileqq.troop.widget.PinnedHeaderIphoneTreeView;
import com.tencent.mobileqq.troop.widget.SingleLineHotwordTextView;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.List;

public class GroupFileSearchDialog
  extends Dialog
  implements Handler.Callback, View.OnClickListener, GroupFileSearchExpandableListAdapter.FileSelectListener, SearchTask.SearchTaskCallBack
{
  protected int A = 0;
  protected List<IContactSearchable> B = null;
  protected long C;
  protected List<TroopFileSearchItemData> D = null;
  protected long E = 0L;
  protected BizTroopObserver F = new GroupFileSearchDialog.6(this);
  protected WatchTogetherObserver G = new GroupFileSearchDialog.7(this);
  private GroupFileSearchDialog.ClickListener H;
  private ChooseFileInfo I = new ChooseFileInfo(1);
  protected PinnedHeaderIphoneTreeView a;
  public GroupFileViewMoreRelativeLayout b;
  protected ViewGroup c;
  protected TextView d;
  protected TextView e;
  protected ImageButton f;
  protected QQBlurView g;
  protected Button h;
  protected EditText i;
  protected RelativeLayout j;
  protected GroupFileSearchExpandableListAdapter k;
  protected QQAppInterface l;
  protected Activity m;
  protected Handler n;
  protected CountdownTimeTask o = null;
  protected SearchTask p = null;
  protected boolean q = true;
  protected Object r = new Object();
  protected boolean s = false;
  protected boolean t = false;
  protected boolean u = false;
  protected boolean v = false;
  protected String w = "";
  protected int x = 0;
  protected String y = null;
  protected boolean z = false;
  
  public GroupFileSearchDialog(Activity paramActivity, QQAppInterface paramQQAppInterface, long paramLong, GroupFileSearchDialog.ClickListener paramClickListener)
  {
    super(paramActivity, 2131952330);
    this.m = paramActivity;
    this.l = paramQQAppInterface;
    this.C = paramLong;
    a(paramActivity);
    this.j = ((RelativeLayout)findViewById(2131444724));
    this.j.setVisibility(8);
    this.a = ((PinnedHeaderIphoneTreeView)findViewById(2131445451));
    findViewById(2131445458).setVisibility(8);
    this.c = ((ViewGroup)findViewById(2131437624));
    this.d = ((TextView)findViewById(2131437626));
    this.e = ((TextView)findViewById(2131448723));
    this.f = ((ImageButton)findViewById(2131435215));
    this.h = ((Button)findViewById(2131450032));
    this.h.setEnabled(false);
    this.n = new Handler(this);
    this.H = paramClickListener;
    a();
    f();
    b(paramActivity);
    a(this.a);
    this.l.addObserver(this.F);
    this.l.addObserver(this.G);
    ThreadManager.post(new GroupFileSearchDialog.1(this), 8, null, true);
  }
  
  private void a(ListView paramListView)
  {
    Object localObject = new RelativeLayout(this.m);
    ((RelativeLayout)localObject).addView(new View(this.m), new RelativeLayout.LayoutParams(-1, AIOUtils.b(50.0F, this.m.getResources())));
    paramListView.addFooterView((View)localObject);
    localObject = this.g;
    if (localObject != null)
    {
      ((QQBlurView)localObject).c();
      this.g = null;
    }
    this.g = ((QQBlurView)findViewById(2131449300));
    this.g.setVisibility(0);
    this.g.a(paramListView);
    paramListView = this.g;
    paramListView.b(paramListView);
    this.g.c(-1);
    this.g.a(new ColorDrawable(Color.parseColor("#E5EBEDF5")));
    paramListView = this.g;
    boolean bool;
    if (Build.VERSION.SDK_INT >= 24) {
      bool = true;
    } else {
      bool = false;
    }
    paramListView.setEnableBlur(bool);
    this.g.setDisableBlurDrawableRes(2130852377);
    this.g.b(0);
    this.g.a(8.0F);
    this.g.a(8);
    this.g.d();
    this.g.a();
  }
  
  private void f()
  {
    this.f.setOnClickListener(this);
    this.h.setOnClickListener(this);
    Button localButton = (Button)findViewById(2131429816);
    localButton.setVisibility(0);
    localButton.setOnClickListener(this);
  }
  
  protected String a(int paramInt)
  {
    if (paramInt > 1000) {
      return this.m.getString(2131895135);
    }
    return this.m.getString(2131895134, new Object[] { Integer.valueOf(paramInt) });
  }
  
  protected void a()
  {
    this.i = ((EditText)findViewById(2131432634));
    this.i.setImeOptions(3);
    this.i.setOnEditorActionListener(new GroupFileSearchDialog.4(this));
    this.i.addTextChangedListener(new GroupFileSearchDialog.5(this));
    this.i.setSelection(0);
    this.i.requestFocus();
  }
  
  public void a(int paramInt, List<? extends ISearchable> paramList)
  {
    if (paramInt == 1)
    {
      a(this.l, this.C, this.w, this.y);
      paramList.clear();
    }
  }
  
  protected void a(Activity paramActivity)
  {
    requestWindowFeature(1);
    getWindow().setSoftInputMode(36);
    if (!VersionUtils.e()) {
      getWindow().setBackgroundDrawable(new ColorDrawable());
    } else {
      getWindow().setBackgroundDrawable(new ColorDrawable(paramActivity.getResources().getColor(2131166286)));
    }
    setContentView(2131625921);
    findViewById(2131450028).setVisibility(0);
    findViewById(2131437674).setBackgroundResource(2130838958);
    findViewById(2131437674).setOnClickListener(this);
    WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
    localLayoutParams.x = 0;
    localLayoutParams.y = 0;
    localLayoutParams.width = -1;
    localLayoutParams.windowAnimations = 16973824;
    localLayoutParams.gravity = 51;
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      getWindow().addFlags(67108864);
      new SystemBarCompact(this, true, paramActivity.getResources().getColor(2131168092)).init();
      paramActivity = (LinearLayout)findViewById(2131437674);
      paramActivity.setFitsSystemWindows(true);
      paramActivity.setPadding(0, ImmersiveUtils.getScreenHeight(), 0, 0);
    }
  }
  
  public final void a(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        int i1 = this.x;
        if (i1 > 0) {
          return;
        }
        if (TextUtils.isEmpty(paramString1))
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("GroupFileSearchDialog", 4, "doReqTroopFileSearch err marchWord is null--------------");
          }
        }
        else
        {
          this.E = System.currentTimeMillis();
          this.x += 1;
          paramQQAppInterface = (WatchTogetherHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QAV_WT_HANDLER);
          if (paramString2 == null) {
            break label99;
          }
          paramQQAppInterface.a(paramLong, ByteStringMicro.copyFromUtf8(paramString2), paramString1);
        }
        return;
      }
      finally {}
      label99:
      paramString2 = "";
    }
  }
  
  public void a(TroopFileSearchItemData paramTroopFileSearchItemData)
  {
    if (paramTroopFileSearchItemData != null)
    {
      this.I.d = paramTroopFileSearchItemData.a;
      this.I.e = paramTroopFileSearchItemData.i.f;
      localObject = this.I;
      ((ChooseFileInfo)localObject).f = "/";
      ((ChooseFileInfo)localObject).g = paramTroopFileSearchItemData.i.c;
      this.I.h = paramTroopFileSearchItemData.i.m;
      this.I.j = paramTroopFileSearchItemData.i.e;
      this.I.k = paramTroopFileSearchItemData.i.d;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("select file ");
      ((StringBuilder)localObject).append(this.I);
      QLog.d("GroupFileSearchDialog", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.h;
    boolean bool;
    if (paramTroopFileSearchItemData != null) {
      bool = true;
    } else {
      bool = false;
    }
    ((Button)localObject).setEnabled(bool);
  }
  
  protected void a(String paramString)
  {
    try
    {
      boolean bool = this.u;
      if (bool) {
        return;
      }
      if (this.B == null)
      {
        this.s = true;
        this.n.sendEmptyMessage(1);
        return;
      }
      if (this.p != null)
      {
        this.p.cancel(true);
        this.p = null;
        this.n.sendEmptyMessage(2);
      }
      this.n.sendEmptyMessage(1);
      this.p = new SearchTask(paramString, paramString, this.B, this);
      this.p.a();
      return;
    }
    finally {}
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if (this.A <= 0)
    {
      this.e.setVisibility(8);
      return;
    }
    long l1 = System.currentTimeMillis();
    TextPaint localTextPaint = this.i.getPaint();
    float f1 = c() - localTextPaint.measureText(paramString);
    if (f1 < 0.0F)
    {
      this.e.setVisibility(8);
    }
    else if (paramBoolean)
    {
      this.e.setText(a(this.A));
      this.e.setVisibility(0);
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("resetResultNumTextVisible compareWidth = ");
      paramString.append(f1);
      paramString.append(", time = ");
      paramString.append(System.currentTimeMillis() - l1);
      QLog.e("zivonchen", 2, paramString.toString());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Drawable localDrawable;
    if (paramBoolean)
    {
      if (this.j.getVisibility() != 0) {
        this.j.setVisibility(0);
      }
      this.c.setVisibility(0);
      this.d.setVisibility(0);
      this.a.setVisibility(8);
      this.d.setCompoundDrawablesWithIntrinsicBounds(2130839585, 0, 0, 0);
      this.d.setText(2131892582);
      localDrawable = this.d.getCompoundDrawables()[0];
      if ((localDrawable instanceof Animatable)) {
        ((Animatable)localDrawable).start();
      }
    }
    else
    {
      this.a.setVisibility(0);
      localDrawable = this.d.getCompoundDrawables()[0];
      if ((localDrawable instanceof Animatable)) {
        ((Animatable)localDrawable).stop();
      }
      this.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      this.c.setVisibility(8);
      this.d.setVisibility(8);
    }
  }
  
  protected String b(String paramString)
  {
    float f1 = c();
    TextPaint localTextPaint = this.i.getPaint();
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      if (localTextPaint.measureText(paramString) <= f1) {
        return paramString;
      }
      paramString = new StringBuilder(paramString.substring(0, localTextPaint.breakText(paramString, true, f1 - localTextPaint.measureText("…"), null)));
      paramString.append("…");
      str = paramString.toString();
    }
    return str;
  }
  
  public void b()
  {
    if (this.j.getVisibility() != 0) {
      this.j.setVisibility(0);
    }
    this.c.setVisibility(0);
    this.d.setVisibility(0);
    this.a.setVisibility(8);
    this.d.setText(this.m.getString(2131892104));
    this.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
  }
  
  protected void b(Activity paramActivity)
  {
    this.b = new GroupFileViewMoreRelativeLayout(paramActivity);
    this.b.setBackgroundResource(2130838958);
    this.b.setTextColor(paramActivity.getResources().getColor(2131167993));
    this.a.addFooterView(this.b);
    this.b.setVisibility(8);
    this.k = new GroupFileSearchExpandableListAdapter(this.m, this.l, this.C, this.a, this.n, this);
    this.a.setAdapter(this.k);
    this.a.setGroupIndicator(null);
    this.a.setOnScrollListener(new GroupFileSearchDialog.2(this));
    this.a.setOnTouchListener(new GroupFileSearchDialog.3(this));
  }
  
  public void b(boolean paramBoolean)
  {
    a(false);
    if (paramBoolean)
    {
      if (this.j.getVisibility() != 0) {
        this.j.setVisibility(0);
      }
      this.c.setVisibility(0);
      this.d.setVisibility(0);
      this.a.setVisibility(8);
      this.d.setText(this.m.getString(2131895130, new Object[] { this.w }));
      this.d.setCompoundDrawablesWithIntrinsicBounds(0, 2130844847, 0, 0);
      return;
    }
    this.a.setVisibility(0);
    Drawable localDrawable = this.d.getCompoundDrawables()[0];
    if ((localDrawable instanceof Animatable)) {
      ((Animatable)localDrawable).stop();
    }
    this.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    this.c.setVisibility(8);
    this.d.setVisibility(8);
  }
  
  protected float c()
  {
    float f2 = this.i.getWidth() - DisplayUtils.a(this.m, 20.0F);
    float f1 = f2;
    if (this.A > 0) {
      f1 = f2 - (this.i.getPaint().measureText(a(this.A)) + DisplayUtils.a(this.m, 16.0F));
    }
    f2 = f1;
    if (this.f.getVisibility() == 0) {
      f2 = f1 - (this.f.getWidth() + DisplayUtils.a(this.m, 8.0F));
    }
    return f2;
  }
  
  protected void c(boolean paramBoolean)
  {
    if (this.a.getFirstVisiblePosition() == 0)
    {
      this.b.setVisibility(8);
      return;
    }
    this.b.setVisibility(0);
    if (paramBoolean)
    {
      this.b.setText(2131916806);
      this.b.a();
      return;
    }
    this.b.setText(2131892582);
    this.b.setTextLeftDrawable(2130839585);
  }
  
  protected void d()
  {
    this.e.setVisibility(8);
    this.u = true;
    this.n.removeCallbacksAndMessages(null);
    CountdownTimeTask localCountdownTimeTask = this.o;
    if (localCountdownTimeTask != null)
    {
      localCountdownTimeTask.b();
      this.o = null;
    }
    this.c.setVisibility(8);
    this.d.setVisibility(8);
    this.a.setVisibility(8);
    this.j.setVisibility(8);
    InputMethodUtil.a(this.i);
  }
  
  public void dismiss()
  {
    this.u = true;
    InputMethodUtil.b(this.i);
    SingleLineHotwordTextView.a();
    Object localObject = this.B;
    if (localObject != null)
    {
      ((List)localObject).clear();
      this.B = null;
    }
    localObject = this.D;
    if (localObject != null)
    {
      ((List)localObject).clear();
      this.D = null;
    }
    localObject = this.o;
    if (localObject != null)
    {
      ((CountdownTimeTask)localObject).b();
      this.o = null;
    }
    localObject = this.p;
    if (localObject != null) {
      ((SearchTask)localObject).cancel(true);
    }
    localObject = this.n;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.k;
    if (localObject != null)
    {
      ((GroupFileSearchExpandableListAdapter)localObject).b();
      this.k = null;
    }
    this.l.removeObserver(this.F);
    this.l.removeObserver(this.G);
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void e()
  {
    if (this.e.getVisibility() != 0)
    {
      this.e.setText(a(this.A));
      this.e.setVisibility(0);
      this.v = true;
      String str = b(this.i.getText().toString());
      if (!TextUtils.isEmpty(str))
      {
        this.i.setText(str);
        this.i.setSelection(str.length());
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.u) {
      return true;
    }
    int i1 = paramMessage.what;
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3)
        {
          if (i1 != 4)
          {
            if (i1 != 5) {
              return false;
            }
            a(false);
            a(this.i.getText().toString(), true);
            if (this.j.getVisibility() != 0) {
              this.j.setVisibility(0);
            }
            if (this.t) {
              this.k.a();
            }
            if (this.q)
            {
              this.q = false;
              InputMethodUtil.b(this.i);
            }
            c(this.z);
            this.k.a(this.D, this.w);
            this.k.notifyDataSetChanged();
            if (this.t)
            {
              this.a.setSelectedGroup(0);
              this.t = false;
            }
            long l1 = System.currentTimeMillis() - this.E;
            paramMessage = this.i.getText().toString().trim().toLowerCase();
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("REFRESH_LIST text = ");
              localStringBuilder.append(paramMessage);
              localStringBuilder.append(", lastHotword = ");
              localStringBuilder.append(this.w);
              localStringBuilder.append(", time = ");
              localStringBuilder.append(l1);
              QLog.e("zivonchen", 2, localStringBuilder.toString());
            }
            if ((!paramMessage.equals(this.w)) && (l1 >= 800L))
            {
              this.y = null;
              this.t = true;
              this.w = paramMessage;
              a(this.w);
              this.o = null;
              return false;
            }
          }
          else
          {
            b(false);
            return false;
          }
        }
        else
        {
          b(true);
          return false;
        }
      }
      else
      {
        a(false);
        return false;
      }
    }
    else {
      a(true);
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131450032: 
      paramView = this.H;
      if (paramView != null)
      {
        paramView.b(this.I);
        return;
      }
      break;
    case 2131435215: 
      this.i.setText("");
      d();
      return;
    case 2131429816: 
    case 2131437674: 
      dismiss();
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    Handler localHandler = this.n;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.wtogether.view.GroupFileSearchDialog
 * JD-Core Version:    0.7.0.1
 */