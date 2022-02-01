package com.tencent.mobileqq.activity.aio.item;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/activity/aio/item/TofuAskAnonymouslyItemBuilder$Holder;", "Lcom/tencent/mobileqq/activity/aio/AbstractChatItemBuilder$ViewHolder;", "()V", "exposure", "", "getExposure", "()Z", "setExposure", "(Z)V", "friendUin", "", "getFriendUin", "()Ljava/lang/String;", "setFriendUin", "(Ljava/lang/String;)V", "ivAnswer", "Landroid/widget/ImageView;", "getIvAnswer", "()Landroid/widget/ImageView;", "setIvAnswer", "(Landroid/widget/ImageView;)V", "ivAnswerHeadCircle", "getIvAnswerHeadCircle", "setIvAnswerHeadCircle", "ivBrowser", "getIvBrowser", "setIvBrowser", "ivComment", "getIvComment", "setIvComment", "ivGrayLineL", "getIvGrayLineL", "setIvGrayLineL", "ivGrayLineR", "getIvGrayLineR", "setIvGrayLineR", "ivLike", "getIvLike", "setIvLike", "ivQues", "getIvQues", "setIvQues", "ivQuesHeadBg", "getIvQuesHeadBg", "setIvQuesHeadBg", "ivQuesHeadCircle", "getIvQuesHeadCircle", "setIvQuesHeadCircle", "ll", "Landroid/view/ViewGroup;", "getLl", "()Landroid/view/ViewGroup;", "setLl", "(Landroid/view/ViewGroup;)V", "rl", "getRl", "setRl", "root", "getRoot", "setRoot", "topContainer", "getTopContainer", "setTopContainer", "tvAnswer", "Landroid/widget/TextView;", "getTvAnswer", "()Landroid/widget/TextView;", "setTvAnswer", "(Landroid/widget/TextView;)V", "tvBrowse", "getTvBrowse", "setTvBrowse", "tvComment", "getTvComment", "setTvComment", "tvLike", "getTvLike", "setTvLike", "tvQues", "getTvQues", "setTvQues", "uinseq", "", "getUinseq", "()J", "setUinseq", "(J)V", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
final class TofuAskAnonymouslyItemBuilder$Holder
  extends AbstractChatItemBuilder.ViewHolder
{
  @Nullable
  private ImageView A;
  private long d;
  @NotNull
  private String e = "";
  private boolean f;
  @Nullable
  private ViewGroup g;
  @Nullable
  private ViewGroup h;
  @Nullable
  private ViewGroup i;
  @Nullable
  private ImageView j;
  @Nullable
  private ImageView k;
  @Nullable
  private ImageView l;
  @Nullable
  private ImageView m;
  @Nullable
  private ImageView n;
  @Nullable
  private TextView o;
  @Nullable
  private ImageView p;
  @Nullable
  private ViewGroup s;
  @Nullable
  private ImageView t;
  @Nullable
  private TextView u;
  @Nullable
  private ImageView v;
  @Nullable
  private TextView w;
  @Nullable
  private TextView x;
  @Nullable
  private ImageView y;
  @Nullable
  private TextView z;
  
  @NotNull
  public final String a()
  {
    return this.e;
  }
  
  public final void a(long paramLong)
  {
    this.d = paramLong;
  }
  
  public final void a(@Nullable ViewGroup paramViewGroup)
  {
    this.g = paramViewGroup;
  }
  
  public final void a(@Nullable ImageView paramImageView)
  {
    this.j = paramImageView;
  }
  
  public final void a(@Nullable TextView paramTextView)
  {
    this.o = paramTextView;
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.e = paramString;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public final void b(@Nullable ViewGroup paramViewGroup)
  {
    this.h = paramViewGroup;
  }
  
  public final void b(@Nullable ImageView paramImageView)
  {
    this.k = paramImageView;
  }
  
  public final void b(@Nullable TextView paramTextView)
  {
    this.u = paramTextView;
  }
  
  public final boolean b()
  {
    return this.f;
  }
  
  @Nullable
  public final ViewGroup c()
  {
    return this.g;
  }
  
  public final void c(@Nullable ViewGroup paramViewGroup)
  {
    this.i = paramViewGroup;
  }
  
  public final void c(@Nullable ImageView paramImageView)
  {
    this.l = paramImageView;
  }
  
  public final void c(@Nullable TextView paramTextView)
  {
    this.w = paramTextView;
  }
  
  @Nullable
  public final ViewGroup d()
  {
    return this.h;
  }
  
  public final void d(@Nullable ViewGroup paramViewGroup)
  {
    this.s = paramViewGroup;
  }
  
  public final void d(@Nullable ImageView paramImageView)
  {
    this.m = paramImageView;
  }
  
  public final void d(@Nullable TextView paramTextView)
  {
    this.x = paramTextView;
  }
  
  @Nullable
  public final ImageView e()
  {
    return this.j;
  }
  
  public final void e(@Nullable ImageView paramImageView)
  {
    this.n = paramImageView;
  }
  
  public final void e(@Nullable TextView paramTextView)
  {
    this.z = paramTextView;
  }
  
  @Nullable
  public final ImageView f()
  {
    return this.k;
  }
  
  public final void f(@Nullable ImageView paramImageView)
  {
    this.p = paramImageView;
  }
  
  @Nullable
  public final ImageView g()
  {
    return this.l;
  }
  
  public final void g(@Nullable ImageView paramImageView)
  {
    this.t = paramImageView;
  }
  
  @Nullable
  public final ImageView h()
  {
    return this.m;
  }
  
  public final void h(@Nullable ImageView paramImageView)
  {
    this.v = paramImageView;
  }
  
  @Nullable
  public final ImageView i()
  {
    return this.n;
  }
  
  public final void i(@Nullable ImageView paramImageView)
  {
    this.y = paramImageView;
  }
  
  @Nullable
  public final TextView j()
  {
    return this.o;
  }
  
  public final void j(@Nullable ImageView paramImageView)
  {
    this.A = paramImageView;
  }
  
  @Nullable
  public final ImageView k()
  {
    return this.p;
  }
  
  @Nullable
  public final ViewGroup l()
  {
    return this.s;
  }
  
  @Nullable
  public final ImageView m()
  {
    return this.t;
  }
  
  @Nullable
  public final TextView n()
  {
    return this.u;
  }
  
  @Nullable
  public final ImageView o()
  {
    return this.v;
  }
  
  @Nullable
  public final TextView p()
  {
    return this.w;
  }
  
  @Nullable
  public final TextView q()
  {
    return this.x;
  }
  
  @Nullable
  public final ImageView r()
  {
    return this.y;
  }
  
  @Nullable
  public final TextView s()
  {
    return this.z;
  }
  
  @Nullable
  public final ImageView t()
  {
    return this.A;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TofuAskAnonymouslyItemBuilder.Holder
 * JD-Core Version:    0.7.0.1
 */