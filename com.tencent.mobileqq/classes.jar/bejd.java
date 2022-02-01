import android.content.Context;
import android.content.res.Resources;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qq.effect.IQEffect;
import com.tencent.qq.effect.IQEffectLoad;
import com.tencent.qq.effect.engine.QEffectData;

public class bejd
  implements IQEffectLoad
{
  public void load(Context paramContext, IQEffect paramIQEffect, QEffectData paramQEffectData)
  {
    switch (paramQEffectData.resType)
    {
    case 2: 
    default: 
      return;
    case 1: 
      loadFromFile(paramContext, paramIQEffect, paramQEffectData.src);
      return;
    }
    loadFromResource(paramContext, paramIQEffect, paramQEffectData.resId);
  }
  
  public void loadFromAsset(Context paramContext, IQEffect paramIQEffect, String paramString) {}
  
  public void loadFromFile(Context paramContext, IQEffect paramIQEffect, String paramString)
  {
    paramContext = URLDrawable.URLDrawableOptions.obtain();
    paramContext.mLoadingDrawable = beyq.a;
    paramContext.mFailedDrawable = beyq.a;
    paramIQEffect.complete(URLDrawable.getFileDrawable(paramString, paramContext));
  }
  
  public void loadFromResource(Context paramContext, IQEffect paramIQEffect, int paramInt)
  {
    if (paramContext != null) {
      paramIQEffect.complete(paramContext.getResources().getDrawable(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bejd
 * JD-Core Version:    0.7.0.1
 */