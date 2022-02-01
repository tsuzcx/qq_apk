package com.tencent.biz.pubaccount.weishi_new.view;

import UserGrowth.stNotificationRedDot;
import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class RedDotBubblePopupWindow
  extends PopupWindow
  implements View.OnClickListener
{
  private static final int b = ViewUtils.dip2px(8.0F);
  protected Handler a = new Handler(Looper.getMainLooper());
  private Activity c;
  private View d;
  private TextView e;
  private TextView f;
  private TextView g;
  private ArrayList<View> h = new ArrayList();
  private RedDotBubblePopupWindow.RedDotBubblePopupListener i;
  private RedDotBubblePopupWindow.DisPopupRunnable j;
  
  public RedDotBubblePopupWindow(Activity paramActivity, RedDotBubblePopupWindow.RedDotBubblePopupListener paramRedDotBubblePopupListener)
  {
    super(paramActivity);
    this.c = paramActivity;
    this.i = paramRedDotBubblePopupListener;
  }
  
  private void b()
  {
    Iterator localIterator = this.h.iterator();
    int k = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (View)localIterator.next();
      if (((View)localObject).getVisibility() == 0)
      {
        localObject = ((View)localObject).getLayoutParams();
        if ((localObject instanceof ViewGroup.MarginLayoutParams))
        {
          localObject = (ViewGroup.MarginLayoutParams)localObject;
          int m;
          if (k == 0) {
            m = 0;
          } else {
            m = b;
          }
          ((ViewGroup.MarginLayoutParams)localObject).leftMargin = m;
        }
        k += 1;
      }
    }
  }
  
  private void b(View paramView, ArrayList<stNotificationRedDot> paramArrayList)
  {
    paramView.findViewById(2131437520).setOnClickListener(this);
    this.h.clear();
    this.h.add(paramView.findViewById(2131437183));
    this.h.add(paramView.findViewById(2131432788));
    this.h.add(paramView.findViewById(2131439716));
    this.e = ((TextView)paramView.findViewById(2131437189));
    this.f = ((TextView)paramView.findViewById(2131432790));
    this.g = ((TextView)paramView.findViewById(2131439717));
    String str1 = "";
    if (paramArrayList != null)
    {
      Iterator localIterator = paramArrayList.iterator();
      paramArrayList = "";
      paramView = paramArrayList;
      for (;;)
      {
        str2 = str1;
        localObject2 = paramArrayList;
        localObject1 = paramView;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (stNotificationRedDot)localIterator.next();
        if (((stNotificationRedDot)localObject1).type == 2) {
          str1 = ((stNotificationRedDot)localObject1).text;
        } else if (((stNotificationRedDot)localObject1).type == 3) {
          paramArrayList = ((stNotificationRedDot)localObject1).text;
        } else if (((stNotificationRedDot)localObject1).type == 1) {
          paramView = ((stNotificationRedDot)localObject1).text;
        }
      }
    }
    Object localObject2 = "";
    Object localObject1 = localObject2;
    String str2 = str1;
    if (TextUtils.isEmpty(str2))
    {
      ((View)this.h.get(0)).setVisibility(8);
    }
    else
    {
      ((View)this.h.get(0)).setVisibility(0);
      this.e.setText(str2);
    }
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      ((View)this.h.get(1)).setVisibility(8);
    }
    else
    {
      ((View)this.h.get(1)).setVisibility(0);
      this.f.setText((CharSequence)localObject2);
    }
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      ((View)this.h.get(2)).setVisibility(8);
      return;
    }
    ((View)this.h.get(2)).setVisibility(0);
    this.g.setText((CharSequence)localObject1);
  }
  
  public void a()
  {
    if (isShowing()) {
      dismiss();
    }
    Handler localHandler = this.a;
    if (localHandler != null)
    {
      RedDotBubblePopupWindow.DisPopupRunnable localDisPopupRunnable = this.j;
      if (localDisPopupRunnable != null)
      {
        localHandler.removeCallbacksAndMessages(localDisPopupRunnable);
        this.j = null;
      }
    }
    this.d = null;
    this.c = null;
  }
  
  public void a(View paramView, ArrayList<stNotificationRedDot> paramArrayList)
  {
    if (isShowing()) {
      dismiss();
    }
    if (paramView == null) {
      return;
    }
    if (this.d == null)
    {
      setBackgroundDrawable(new BitmapDrawable());
      this.d = LayoutInflater.from(this.c).inflate(2131626031, null);
      b(this.d, paramArrayList);
      setContentView(this.d);
      setWidth(-2);
      setHeight(-2);
      b();
    }
    paramView.post(new RedDotBubblePopupWindow.1(this, paramView));
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131437520)
    {
      paramView = this.i;
      if (paramView != null) {
        paramView.a();
      }
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.RedDotBubblePopupWindow
 * JD-Core Version:    0.7.0.1
 */