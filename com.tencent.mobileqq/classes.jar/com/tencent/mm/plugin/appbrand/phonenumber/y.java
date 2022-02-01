package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManagerView;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberManagerView;", "mContext", "Landroid/content/Context;", "mPhoneNumberManagerLogic", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberManageLogic;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberManageLogic;)V", "MAX_COUNT", "", "getMAX_COUNT", "()I", "mAddPhoneLineV", "Landroid/view/View;", "mAddPhoneTv", "Landroid/widget/TextView;", "mContentView", "mExposeTv", "mItemAdapter", "Lcom/tencent/mm/plugin/appbrand/phonenumber/DeleteItemAdapter;", "mListRv", "Landroidx/recyclerview/widget/RecyclerView;", "mTipsTv", "getView", "updateView", "", "showDelete", "", "phoneItems", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class y
  implements p
{
  public static final y.a a = new y.a(null);
  private final int b;
  private View c;
  private RecyclerView d;
  private j e;
  private TextView f;
  private View g;
  private TextView h;
  private TextView i;
  private final Context j;
  private final o k;
  
  public y(@NotNull Context paramContext, @Nullable o paramo)
  {
    this.j = paramContext;
    this.k = paramo;
    this.b = 3;
    paramContext = this.j;
    paramo = null;
    this.c = View.inflate(paramContext, 2131624219, null);
    paramContext = this.c;
    if (paramContext != null) {
      paramContext = (RecyclerView)paramContext.findViewById(2131440066);
    } else {
      paramContext = null;
    }
    this.d = paramContext;
    paramContext = this.d;
    if (paramContext != null) {
      paramContext.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(this.j));
    }
    this.e = new j(this.j, new ArrayList(), (Function1)new y.1(this));
    paramContext = this.d;
    if (paramContext != null) {
      paramContext.setAdapter((RecyclerView.Adapter)this.e);
    }
    paramContext = this.c;
    if (paramContext != null) {
      paramContext = (TextView)paramContext.findViewById(2131440057);
    } else {
      paramContext = null;
    }
    this.f = paramContext;
    paramContext = this.f;
    if (paramContext != null) {
      paramContext.setOnClickListener((View.OnClickListener)new y.2(this));
    }
    paramContext = this.c;
    if (paramContext != null) {
      paramContext = paramContext.findViewById(2131440065);
    } else {
      paramContext = null;
    }
    this.g = paramContext;
    paramContext = this.c;
    if (paramContext != null) {
      paramContext = (TextView)paramContext.findViewById(2131440064);
    } else {
      paramContext = null;
    }
    this.h = paramContext;
    paramContext = this.h;
    if (paramContext != null) {
      paramContext.setMovementMethod(LinkMovementMethod.getInstance());
    }
    Object localObject = this.h;
    if (localObject != null)
    {
      paramContext = this.k;
      if (paramContext != null) {
        paramContext = paramContext.d();
      } else {
        paramContext = null;
      }
      ((TextView)localObject).setText((CharSequence)paramContext);
    }
    localObject = this.c;
    paramContext = paramo;
    if (localObject != null) {
      paramContext = (TextView)((View)localObject).findViewById(2131440058);
    }
    this.i = paramContext;
  }
  
  @Nullable
  public View a()
  {
    return this.c;
  }
  
  public void a(boolean paramBoolean, @NotNull List<r> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "phoneItems");
    Object localObject = this.e;
    if (localObject != null) {
      ((j)localObject).a(paramBoolean);
    }
    localObject = this.e;
    if (localObject != null) {
      ((j)localObject).notifyDataSetChanged();
    }
    localObject = this.e;
    if (localObject != null) {
      ((j)localObject).a(paramBoolean, paramList);
    }
    if ((!paramBoolean) && (paramList.size() < this.b))
    {
      localObject = this.f;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
      localObject = this.g;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
    }
    else
    {
      localObject = this.f;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
      localObject = this.g;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
    }
    if (paramBoolean)
    {
      paramList = this.i;
      if (paramList != null) {
        paramList.setVisibility(8);
      }
    }
    else if (paramList.size() >= this.b)
    {
      paramList = this.i;
      if (paramList != null) {
        paramList.setVisibility(0);
      }
    }
    else
    {
      paramList = this.i;
      if (paramList != null) {
        paramList.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.y
 * JD-Core Version:    0.7.0.1
 */