package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class w$h
  implements Runnable
{
  w$h(w paramw) {}
  
  public final void run()
  {
    Object localObject = this.a;
    String str = ((w)localObject).u();
    Context localContext = this.a.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    w.a((w)localObject, new q(str, localContext, this.a.m()));
    this.a.c().setAdapter((RecyclerView.Adapter)w.a(this.a));
    if (this.a.m().size() == 0)
    {
      this.a.j().setVisibility(0);
      this.a.c().setVisibility(8);
      this.a.d().setVisibility(8);
      return;
    }
    if (this.a.m().size() == 1)
    {
      this.a.j().setVisibility(8);
      this.a.c().setVisibility(0);
      localObject = this.a.c().getAdapter();
      if (localObject != null) {
        ((RecyclerView.Adapter)localObject).notifyDataSetChanged();
      }
      this.a.d().setVisibility(0);
      this.a.d().setText((CharSequence)this.a.getContext().getString(2131886975));
      if (!v.a.a().a()) {
        this.a.d().setVisibility(8);
      }
    }
    else
    {
      this.a.j().setVisibility(8);
      this.a.c().setVisibility(0);
      this.a.d().setVisibility(0);
      localObject = this.a.c().getAdapter();
      if (localObject != null) {
        ((RecyclerView.Adapter)localObject).notifyDataSetChanged();
      }
      this.a.d().setText((CharSequence)this.a.getContext().getString(2131886973));
      if (!v.a.a().a()) {
        this.a.d().setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.w.h
 * JD-Core Version:    0.7.0.1
 */