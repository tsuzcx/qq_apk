package com.tencent.biz.pubaccount.util;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/util/RIJBlackWhiteModeHelper;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "blackWhiteConfig", "", "getBlackWhiteConfig", "()Z", "setBlackWhiteConfig", "(Z)V", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "addBlackWhiteMode", "", "canvas", "Landroid/graphics/Canvas;", "needConfig", "drawCanvas", "Lkotlin/Function1;", "isBlackWhiteMode", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJBlackWhiteModeHelper
{
  public static final RIJBlackWhiteModeHelper a = new RIJBlackWhiteModeHelper();
  @NotNull
  private static final String b = "RIJBlackWhiteModeHelper";
  @NotNull
  private static final Paint c = new Paint();
  private static boolean d;
  
  static
  {
    ColorMatrix localColorMatrix = new ColorMatrix();
    localColorMatrix.setSaturation(0.0F);
    c.setColorFilter((ColorFilter)new ColorMatrixColorFilter(localColorMatrix));
  }
  
  public final void a(@NotNull Canvas paramCanvas, boolean paramBoolean, @NotNull Function1<? super Canvas, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "drawCanvas");
    d = b();
    int i;
    if ((paramBoolean) && (!d)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      paramCanvas.saveLayer(null, c, 31);
      paramFunction1.invoke(paramCanvas);
      paramCanvas.restore();
      return;
    }
    paramFunction1.invoke(paramCanvas);
  }
  
  public final boolean a()
  {
    return d;
  }
  
  public final boolean b()
  {
    AladdinConfig localAladdinConfig = Aladdin.get(320);
    boolean bool = false;
    if (localAladdinConfig.getIntegerFromString("is_black_white_mode", 0) == 1) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.RIJBlackWhiteModeHelper
 * JD-Core Version:    0.7.0.1
 */