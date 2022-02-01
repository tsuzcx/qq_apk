package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader;
import com.tencent.mm.modelappbrand.image.WxaIconTransformation;
import com.tencent.mm.ui.base.AuthorizeItemListView;
import java.util.ArrayList;
import java.util.List;

public class c
  extends b
{
  private final String a;
  private final String b;
  private AuthorizeItemListView c;
  private c.b d;
  private LinearLayout e;
  private Context f;
  
  public c(Context paramContext, List<c.c> paramList, String paramString1, String paramString2, c.a parama)
  {
    super(paramContext, 2131953305);
    this.f = paramContext;
    this.b = af.b(paramString1);
    this.a = paramString2;
    a(a(paramList), parama);
  }
  
  private static ArrayList<c.c> a(List<c.c> paramList)
  {
    if ((paramList instanceof ArrayList)) {
      return (ArrayList)paramList;
    }
    return new ArrayList(paramList);
  }
  
  private void a(ArrayList<c.c> paramArrayList, c.a parama)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      ViewGroup localViewGroup = (ViewGroup)LayoutInflater.from(this.f).inflate(2131624203, null);
      setContentView(localViewGroup);
      Object localObject = (ImageView)localViewGroup.findViewById(2131428621);
      AppBrandSimpleImageLoader.instance().attach((ImageView)localObject, this.a, 2130842125, WxaIconTransformation.INSTANCE);
      ((TextView)localViewGroup.findViewById(2131428633)).setText(this.f.getString(2131891422, new Object[] { this.b }));
      this.c = ((AuthorizeItemListView)localViewGroup.findViewById(2131428889));
      this.d = new c.b(paramArrayList);
      this.c.setAdapter(this.d);
      if (paramArrayList.size() > 5)
      {
        this.c.a = paramArrayList.size();
        this.e = ((LinearLayout)localViewGroup.findViewById(2131428902));
        localObject = (LinearLayout.LayoutParams)this.e.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).height = this.f.getResources().getDimensionPixelSize(2131297768);
        this.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      ((Button)localViewGroup.findViewById(2131437720)).setOnClickListener(new c.1(this, paramArrayList, parama, this));
      ((Button)localViewGroup.findViewById(2131437728)).setOnClickListener(new c.2(this, paramArrayList, parama, this));
      setCanceledOnTouchOutside(false);
      setOnCancelListener(new c.3(this, parama));
      return;
    }
    throw new IllegalArgumentException("scopeInfoList is empty or null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.c
 * JD-Core Version:    0.7.0.1
 */