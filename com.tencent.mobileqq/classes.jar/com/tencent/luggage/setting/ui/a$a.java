package com.tencent.luggage.setting.ui;

import android.graphics.Bitmap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/setting/ui/WxaUserInfoListAdapter$Item;", "", "title", "", "subTitle", "scope", "check", "", "iconUrl", "avatarId", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;I)V", "icon", "Landroid/graphics/Bitmap;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLandroid/graphics/Bitmap;I)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Bitmap;ZLjava/lang/String;I)V", "getAvatarId", "()I", "setAvatarId", "(I)V", "getCheck", "()Z", "setCheck", "(Z)V", "getIcon", "()Landroid/graphics/Bitmap;", "setIcon", "(Landroid/graphics/Bitmap;)V", "getIconUrl", "()Ljava/lang/String;", "setIconUrl", "(Ljava/lang/String;)V", "getScope", "getSubTitle", "getTitle", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class a$a
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
  
  public a$a(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @Nullable Bitmap paramBitmap, boolean paramBoolean, @NotNull String paramString4, int paramInt)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramBitmap;
    this.e = paramBoolean;
    this.f = paramString4;
    this.g = paramInt;
  }
  
  public a$a(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, boolean paramBoolean, @NotNull String paramString4, int paramInt)
  {
    this(paramString1, paramString2, paramString3, null, paramBoolean, paramString4, paramInt);
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
  public final Bitmap c()
  {
    return this.d;
  }
  
  public final boolean d()
  {
    return this.e;
  }
  
  @NotNull
  public final String e()
  {
    return this.f;
  }
  
  public final int f()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.setting.ui.a.a
 * JD-Core Version:    0.7.0.1
 */