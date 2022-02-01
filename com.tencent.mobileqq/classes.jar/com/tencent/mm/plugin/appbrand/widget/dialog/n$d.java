package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.h;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "items", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$Item;", "itemAdapter", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter;", "(Landroid/view/View;Ljava/util/List;Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "setIcon", "(Landroid/widget/ImageView;)V", "getItems", "()Ljava/util/List;", "selected", "subTitle", "Landroid/widget/TextView;", "title", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "applyData", "", "item", "position", "", "checkStateChange", "Lkotlin/Function1;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Lkotlin/ParameterName;", "name", "posChanged", "refreshCheckView", "check", "", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class n$d
  extends RecyclerView.ViewHolder
{
  @NotNull
  private ImageView a;
  private final TextView b;
  private final TextView c;
  private final ImageView d;
  @NotNull
  private View e;
  @NotNull
  private final List<n.a> f;
  private final n g;
  
  public n$d(@NotNull View paramView, @NotNull List<n.a> paramList, @NotNull n paramn)
  {
    super(paramView);
    this.e = paramView;
    this.f = paramList;
    this.g = paramn;
    paramView = this.e.findViewById(2131435219);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "view.findViewById(R.id.icon)");
    this.a = ((ImageView)paramView);
    paramView = this.e.findViewById(2131447463);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "view.findViewById(R.id.title)");
    this.b = ((TextView)paramView);
    paramView = this.e.findViewById(2131446539);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "view.findViewById(R.id.sub_title)");
    this.c = ((TextView)paramView);
    paramView = this.e.findViewById(2131445546);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "view.findViewById(R.id.selected)");
    this.d = ((ImageView)paramView);
  }
  
  private final void a(boolean paramBoolean, n.a parama)
  {
    n.b localb;
    if (this.f.size() == 1)
    {
      this.d.setVisibility(0);
      if (paramBoolean)
      {
        localb = this.g.a();
        if (localb != null) {
          localb.a(parama);
        }
      }
    }
    else
    {
      if (paramBoolean)
      {
        localb = this.g.a();
        if (localb != null) {
          localb.a(parama);
        }
        this.d.setVisibility(0);
        return;
      }
      this.d.setVisibility(8);
    }
  }
  
  @NotNull
  public final View a()
  {
    return this.e;
  }
  
  public final void a(@NotNull n.a parama, int paramInt, @NotNull Function1<? super ArrayList<Integer>, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(parama, "item");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "checkStateChange");
    this.a.setImageResource(2130839758);
    TextView localTextView = this.b;
    Object localObject = com.tencent.luggage.wxa.pr.a.a().a(this.b.getContext(), (CharSequence)parama.a(), this.b.getTextSize());
    if (localObject != null) {
      localObject = (CharSequence)localObject;
    } else {
      localObject = (CharSequence)"";
    }
    localTextView.setText((CharSequence)localObject);
    boolean bool = TextUtils.isEmpty((CharSequence)parama.b());
    int i = 0;
    if (!bool)
    {
      this.c.setVisibility(0);
      localTextView = this.c;
      localObject = parama.b();
      if (localObject != null) {
        localObject = (CharSequence)localObject;
      } else {
        localObject = (CharSequence)"";
      }
      localTextView.setText((CharSequence)localObject);
    }
    else
    {
      this.c.setVisibility(8);
    }
    a(parama.e(), parama);
    if (parama.d() != null)
    {
      localObject = com.tencent.luggage.wxa.qz.b.a(parama.d(), false, com.tencent.luggage.wxa.qx.a.e(this.e.getContext(), 4) * 1.0F, false);
      if (localObject != null) {
        this.a.setImageBitmap((Bitmap)localObject);
      } else {
        this.a.setImageResource(2130839758);
      }
    }
    else
    {
      if (((CharSequence)parama.f()).length() > 0) {
        i = 1;
      }
      if (i != 0) {
        AppBrandSimpleImageLoader.instance().attach(this.a, parama.f(), 2130839758, (AppBrandSimpleImageLoader.h)new n.d.a(this));
      }
    }
    this.e.setOnClickListener((View.OnClickListener)new n.d.b(this, parama, paramInt, paramFunction1));
    this.e.setOnLongClickListener((View.OnLongClickListener)new n.d.c(this, parama, paramInt));
  }
  
  @NotNull
  public final List<n.a> b()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.n.d
 * JD-Core Version:    0.7.0.1
 */