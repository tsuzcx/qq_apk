package com.tencent.comic.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.comic.data.VipComicDC01327ReportData;
import com.tencent.comic.hippy.api.ComicHippyBackEventInterceptorProxy;
import com.tencent.mobileqq.activity.richmedia.Size;
import com.tencent.mobileqq.util.DisplayUtil;
import java.util.List;
import mqq.util.WeakReference;

public class ComicCancelRedPointPopDialog
  extends Dialog
  implements View.OnClickListener
{
  public boolean a = false;
  public int b = 0;
  private ComicHorizontalCenterScrollView c = null;
  private ComicCancelRedPointPopItemView[] d = new ComicCancelRedPointPopItemView[5];
  private ImageView[] e = new ImageView[5];
  private Rect[] f = new Rect[5];
  private LinearLayout g = null;
  private TextView h = null;
  private WeakReference<Activity> i;
  private ComicHorizontalCenterScrollView.OnCustomScrollListener j = new ComicCancelRedPointPopDialog.1(this);
  
  public ComicCancelRedPointPopDialog(@NonNull Context paramContext, Activity paramActivity, int paramInt)
  {
    super(paramContext, paramInt);
    this.i = new WeakReference(paramActivity);
    setContentView(1996816384);
    a(paramContext);
    setCanceledOnTouchOutside(false);
  }
  
  private int a(int paramInt)
  {
    int k = 0;
    for (;;)
    {
      Rect[] arrayOfRect = this.f;
      if (k >= arrayOfRect.length) {
        break;
      }
      if ((arrayOfRect[k].left <= paramInt) && (paramInt <= this.f[k].right)) {
        return k;
      }
      k += 1;
    }
    return 0;
  }
  
  private void a(Context paramContext)
  {
    Size localSize = DisplayUtil.a(paramContext);
    this.c = ((ComicHorizontalCenterScrollView)findViewById(1996750856));
    Object localObject = (LinearLayout.LayoutParams)this.c.getLayoutParams();
    if (localObject == null)
    {
      localObject = new LinearLayout.LayoutParams(localSize.a, DisplayUtil.a(paramContext, 346.5F));
      ((LinearLayout.LayoutParams)localObject).topMargin = DisplayUtil.a(paramContext, 15.0F);
    }
    else
    {
      ((LinearLayout.LayoutParams)localObject).width = localSize.a;
    }
    this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
    int m = DisplayUtil.a(paramContext, 260.0F);
    int n = DisplayUtil.a(paramContext, 8.0F);
    this.c.setBaseInfo(m, n, this.j);
    this.h = ((TextView)findViewById(1996750858));
    paramContext = this.d;
    localObject = (ComicCancelRedPointPopItemView)findViewById(1996750859);
    int k = 0;
    paramContext[0] = localObject;
    this.d[1] = ((ComicCancelRedPointPopItemView)findViewById(1996750860));
    this.d[2] = ((ComicCancelRedPointPopItemView)findViewById(1996750861));
    this.d[3] = ((ComicCancelRedPointPopItemView)findViewById(1996750862));
    this.d[4] = ((ComicCancelRedPointPopItemView)findViewById(1996750863));
    this.e[0] = ((ImageView)findViewById(1996750848));
    this.e[1] = ((ImageView)findViewById(1996750849));
    this.e[2] = ((ImageView)findViewById(1996750850));
    this.e[3] = ((ImageView)findViewById(1996750851));
    this.e[4] = ((ImageView)findViewById(1996750852));
    this.g = ((LinearLayout)findViewById(1996750853));
    this.h.setOnClickListener(this);
    m += n;
    for (;;)
    {
      paramContext = this.d;
      if (k >= paramContext.length) {
        break;
      }
      paramContext[k].b = k;
      paramContext[k].setOnClickListener(this);
      paramContext = new Rect();
      paramContext.left = (k * m);
      paramContext.right = (paramContext.left + m);
      this.f[k] = paramContext;
      k += 1;
    }
  }
  
  private void a(ComicCancelRedPointPopItemData paramComicCancelRedPointPopItemData)
  {
    Activity localActivity = (Activity)this.i.get();
    if ((localActivity != null) && (paramComicCancelRedPointPopItemData != null))
    {
      this.a = true;
      VipComicDC01327ReportData localVipComicDC01327ReportData = new VipComicDC01327ReportData().a("2000").b("2").c("20249").d("4").e(paramComicCancelRedPointPopItemData.comicId);
      ComicHippyBackEventInterceptorProxy.INSTANCE.reportData(localVipComicDC01327ReportData);
    }
    try
    {
      ComicHippyBackEventInterceptorProxy.INSTANCE.openReader(localActivity, paramComicCancelRedPointPopItemData.comicId);
      label77:
      dismiss();
      return;
    }
    catch (Throwable paramComicCancelRedPointPopItemData)
    {
      break label77;
    }
  }
  
  private void b(int paramInt)
  {
    int k = 0;
    for (;;)
    {
      Object localObject = this.e;
      if (k >= localObject.length) {
        break;
      }
      localObject = localObject[k];
      int m;
      if (k == paramInt) {
        m = 1996685313;
      } else {
        m = 1996685312;
      }
      ((ImageView)localObject).setImageResource(m);
      k += 1;
    }
  }
  
  public void a(List<ComicCancelRedPointPopItemData> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.b = 0;
    int k = 0;
    while (k < this.d.length)
    {
      if (k >= paramList.size())
      {
        this.d[k].setVisibility(8);
        this.e[k].setVisibility(8);
        this.d[k].setData(null);
      }
      else
      {
        this.b += 1;
        this.d[k].setVisibility(0);
        this.e[k].setVisibility(0);
        this.d[k].setData((ComicCancelRedPointPopItemData)paramList.get(k));
      }
      k += 1;
    }
    this.c.scrollTo(0, 0);
    b(0);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 1996750863: 
      paramView = this.d[4].a;
      break;
    case 1996750862: 
      paramView = this.d[3].a;
      break;
    case 1996750861: 
      paramView = this.d[2].a;
      break;
    case 1996750860: 
      paramView = this.d[1].a;
      break;
    case 1996750859: 
      paramView = this.d[0].a;
      a(paramView);
      return;
    }
    dismiss();
  }
  
  public void show()
  {
    super.show();
    VipComicDC01327ReportData localVipComicDC01327ReportData = new VipComicDC01327ReportData().a("2000").b("3").c("39973");
    ComicHippyBackEventInterceptorProxy.INSTANCE.reportData(localVipComicDC01327ReportData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.ui.ComicCancelRedPointPopDialog
 * JD-Core Version:    0.7.0.1
 */