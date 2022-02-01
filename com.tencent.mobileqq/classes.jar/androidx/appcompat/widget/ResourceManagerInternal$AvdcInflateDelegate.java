package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import org.xmlpull.v1.XmlPullParser;

class ResourceManagerInternal$AvdcInflateDelegate
  implements ResourceManagerInternal.InflateDelegate
{
  public Drawable createFromXmlInner(@NonNull Context paramContext, @NonNull XmlPullParser paramXmlPullParser, @NonNull AttributeSet paramAttributeSet, @Nullable Resources.Theme paramTheme)
  {
    try
    {
      paramContext = AnimatedVectorDrawableCompat.createFromXmlInner(paramContext, paramContext.getResources(), paramXmlPullParser, paramAttributeSet, paramTheme);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", paramContext);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.ResourceManagerInternal.AvdcInflateDelegate
 * JD-Core Version:    0.7.0.1
 */