package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.graphics.Bitmap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$Item;", "", "title", "", "subTitle", "scope", "check", "", "iconUrl", "avatarId", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;I)V", "icon", "Landroid/graphics/Bitmap;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLandroid/graphics/Bitmap;I)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Bitmap;ZLjava/lang/String;I)V", "getAvatarId", "()I", "setAvatarId", "(I)V", "getCheck", "()Z", "setCheck", "(Z)V", "getIcon", "()Landroid/graphics/Bitmap;", "setIcon", "(Landroid/graphics/Bitmap;)V", "getIconUrl", "()Ljava/lang/String;", "setIconUrl", "(Ljava/lang/String;)V", "getScope", "getSubTitle", "getTitle", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class n$a
{
  @Nullable
  private final String a;
  @Nullable
  private final String b;
  @Nullable
  private final String c;
  @Nullable
  private Bitmap d;
  private boolean e;
  @NotNull
  private String f;
  private int g;
  
  public n$a(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @Nullable Bitmap paramBitmap, boolean paramBoolean, @NotNull String paramString4, int paramInt)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramBitmap;
    this.e = paramBoolean;
    this.f = paramString4;
    this.g = paramInt;
  }
  
  @Nullable
  public final String a()
  {
    return this.a;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  @Nullable
  public final String b()
  {
    return this.b;
  }
  
  @Nullable
  public final String c()
  {
    return this.c;
  }
  
  @Nullable
  public final Bitmap d()
  {
    return this.d;
  }
  
  public final boolean e()
  {
    return this.e;
  }
  
  @NotNull
  public final String f()
  {
    return this.f;
  }
  
  public final int g()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.n.a
 * JD-Core Version:    0.7.0.1
 */