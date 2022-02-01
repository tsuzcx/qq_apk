package com.tencent.mobileqq.apollo.aio.panel.viewbinder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.model.ApolloTagButtonData;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class ApolloTagActionViewBinder$ApolloActionTagsAdapter
  extends BaseAdapter
{
  private List<ApolloTagButtonData> b;
  private Context c;
  private QQAppInterface d;
  private SessionInfo e;
  private LayoutInflater f;
  private ApolloTagButtonData g = new ApolloTagButtonData(this.a.h, false);
  private HashMap<String, String> h;
  private boolean i;
  private Drawable j;
  
  public ApolloTagActionViewBinder$ApolloActionTagsAdapter(Context paramContext, List<ApolloTagButtonData> paramList, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    this.c = paramList;
    this.b = paramQQAppInterface;
    this.d = paramSessionInfo;
    this.e = paramBoolean;
    this.f = ((LayoutInflater)paramList.getSystemService("layout_inflater"));
    this.b.add(0, this.g);
    boolean bool;
    this.i = bool;
    this.j = a();
  }
  
  private Drawable a()
  {
    Drawable localDrawable = this.c.getResources().getDrawable(2130838460);
    localDrawable.setBounds(0, 0, localDrawable.getMinimumWidth(), localDrawable.getMinimumHeight());
    return localDrawable;
  }
  
  private void a(Button paramButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramButton.setCompoundDrawables(this.j, null, null, null);
      paramButton.setContentDescription(this.c.getString(2131886736));
      return;
    }
    paramButton.setCompoundDrawables(null, null, null, null);
    paramButton.setContentDescription("");
  }
  
  private void a(Button paramButton, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      paramButton.setTextColor(b(paramBoolean1));
      paramButton.setBackgroundDrawable(a(d(paramBoolean1), 14));
    }
    else
    {
      paramButton.setTextColor(c(paramBoolean1));
      paramButton.setBackgroundDrawable(a(e(paramBoolean1), 14));
    }
    a(paramButton, paramBoolean1);
  }
  
  private void a(String paramString)
  {
    Object localObject = this.b;
    if (localObject == null) {
      return;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ApolloTagButtonData localApolloTagButtonData = (ApolloTagButtonData)((Iterator)localObject).next();
      if (paramString.equals(localApolloTagButtonData.tag)) {
        localApolloTagButtonData.isSelected = true;
      } else {
        localApolloTagButtonData.isSelected = false;
      }
    }
    this.a.a(paramString, true);
    notifyDataSetChanged();
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ApolloDtReportUtil.a("aio", "tagpage", "tagexpose", this.h);
      ApolloDtReportUtil.a("aio", "tagpage", "tagclick", this.h);
      return;
    }
    ApolloDtReportUtil.a("aio", "tagpage", "qxtagclick", this.h);
  }
  
  private int b(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.c.getResources().getColor(2131166585);
    }
    return this.c.getResources().getColor(2131166587);
  }
  
  private void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = null;
    for (;;)
    {
      boolean bool;
      try
      {
        Iterator localIterator = this.b.iterator();
        if (localIterator.hasNext())
        {
          ApolloTagButtonData localApolloTagButtonData = (ApolloTagButtonData)localIterator.next();
          if (paramString.equals(localApolloTagButtonData.tag))
          {
            localObject = localApolloTagButtonData;
            continue;
          }
          localApolloTagButtonData.isSelected = false;
          continue;
          if (localObject.isSelected) {
            break label180;
          }
          bool = true;
          localObject.isSelected = bool;
          bool = localObject.isSelected;
          if (bool) {
            ApolloDtReportUtil.a.put(Integer.valueOf(this.a.n), paramString);
          } else {
            ApolloDtReportUtil.a.remove(Integer.valueOf(this.a.n));
          }
          this.h = c(paramString);
          a(bool);
          this.a.a(paramString, bool);
          notifyDataSetChanged();
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("[cmshow]ApolloActionTagsAdapter", 1, paramString, new Object[0]);
        return;
      }
      if (localObject == null)
      {
        return;
        label180:
        bool = false;
      }
    }
  }
  
  private int c(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.c.getResources().getColor(2131167938);
    }
    return this.c.getResources().getColor(2131168422);
  }
  
  private HashMap<String, String> c(String paramString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private int d(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.c.getResources().getColor(2131166584);
    }
    return this.c.getResources().getColor(2131166586);
  }
  
  private int e(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.c.getResources().getColor(2131167936);
    }
    return this.c.getResources().getColor(2131168421);
  }
  
  public Drawable a(int paramInt1, int paramInt2)
  {
    return ViewUtils.getShapeDrawable(paramInt1, ViewUtils.dip2px(paramInt2));
  }
  
  public ApolloTagButtonData a(int paramInt)
  {
    List localList = this.b;
    if (localList == null) {
      return null;
    }
    return (ApolloTagButtonData)localList.get(paramInt);
  }
  
  public int getCount()
  {
    List localList = this.b;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = this.f.inflate(2131624179, paramViewGroup, false);
    }
    paramView = (Button)localView.findViewById(2131430045);
    paramViewGroup = ((ApolloTagButtonData)this.b.get(paramInt)).tag;
    paramView.setText(paramViewGroup);
    paramView.setContentDescription(paramViewGroup);
    a(paramView, ((ApolloTagButtonData)this.b.get(paramInt)).isSelected, ThemeUtil.isNowThemeIsNight(this.d, false, null));
    paramView.setOnClickListener(new ApolloTagActionViewBinder.ApolloActionTagsAdapter.1(this, paramView));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloTagActionViewBinder.ApolloActionTagsAdapter
 * JD-Core Version:    0.7.0.1
 */