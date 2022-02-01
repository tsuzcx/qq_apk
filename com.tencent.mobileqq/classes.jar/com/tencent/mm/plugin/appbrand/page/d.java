package com.tencent.mm.plugin.appbrand.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.jj.a.b;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader;
import com.tencent.mm.modelappbrand.image.WxaIconTransformation;
import com.tencent.mm.plugin.appbrand.widget.h;

@SuppressLint({"ViewConstructor"})
public class d
  extends LinearLayout
{
  private ImageView a;
  private TextView b;
  private Button c;
  
  public d(Context paramContext, @NonNull com.tencent.luggage.wxa.ed.d paramd)
  {
    super(paramContext);
    a(paramd);
  }
  
  private void a(@NonNull com.tencent.luggage.wxa.ed.d paramd)
  {
    inflate(getContext(), 2131624212, this);
    this.a = ((ImageView)findViewById(2131428529));
    this.b = ((TextView)findViewById(2131428531));
    this.c = ((Button)findViewById(2131428528));
    Object localObject = this.b;
    Resources localResources = getResources();
    int i = 1;
    ((TextView)localObject).setText(localResources.getString(2131891453, new Object[] { paramd.i().I }));
    localObject = (LinearLayout.LayoutParams)this.a.getLayoutParams();
    if ((paramd.aj() == null) || (paramd.aj().c() == null) || (!paramd.aj().c().a())) {
      i = 0;
    }
    if (i != 0)
    {
      ((LinearLayout.LayoutParams)localObject).topMargin = com.tencent.luggage.wxa.qx.a.d(getContext(), 2131296770);
      this.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
      requestLayout();
    }
    localObject = new ColorMatrix();
    ((ColorMatrix)localObject).setSaturation(0.0F);
    localObject = new ColorMatrixColorFilter((ColorMatrix)localObject);
    this.a.setColorFilter((ColorFilter)localObject);
    AppBrandSimpleImageLoader.instance().attach(this.a, paramd.i().K, ((h)paramd.d(h.class)).a(), WxaIconTransformation.INSTANCE);
    this.c.setVisibility(8);
    setBackgroundColor(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.d
 * JD-Core Version:    0.7.0.1
 */