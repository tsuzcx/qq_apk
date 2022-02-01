package com.tencent.biz.pubaccount.readinjoy.pts.ui;

import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.ui.vnode.PTSNodeVirtual;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/pts/ui/PTSNodeGif;", "Lcom/tencent/pts/ui/vnode/PTSNodeVirtual;", "Lcom/tencent/biz/pubaccount/readinjoy/pts/ui/PTSGifView;", "appInstance", "Lcom/tencent/pts/core/PTSAppInstance;", "(Lcom/tencent/pts/core/PTSAppInstance;)V", "setAttribute", "", "key", "", "value", "", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class PTSNodeGif
  extends PTSNodeVirtual<PTSGifView>
{
  public static final PTSNodeGif.Companion Companion = new PTSNodeGif.Companion(null);
  @NotNull
  public static final String VIDEO_TAG = "PTSNodeGif";
  
  public PTSNodeGif(@NotNull PTSAppInstance paramPTSAppInstance)
  {
    super(paramPTSAppInstance);
  }
  
  public boolean setAttribute(@Nullable String paramString, @Nullable Object paramObject)
  {
    QLog.d("PTSNodeGif", 1, "key:" + paramString + ",value:" + paramObject);
    if (paramString == null) {}
    for (;;)
    {
      return super.setAttribute(paramString, paramObject);
      switch (paramString.hashCode())
      {
      default: 
        break;
      case -1654132239: 
        if (paramString.equals("pts-gif:scale-type"))
        {
          Integer localInteger = StringsKt.toIntOrNull(String.valueOf(paramObject));
          if (localInteger != null)
          {
            int i = ((Number)localInteger).intValue();
            ((PTSGifView)getView()).setScaleType(i);
          }
        }
        break;
      case -545139630: 
        if (paramString.equals("pts-gif:gif-url")) {
          ((PTSGifView)getView()).setGifUrl(String.valueOf(paramObject));
        }
        break;
      case -767755323: 
        if (paramString.equals("pts-gif:cover-url")) {
          ((PTSGifView)getView()).setCoverUrl(String.valueOf(paramObject));
        }
        break;
      case 1149179075: 
        if (paramString.equals("pts-gif:need-gif-url")) {
          ((PTSGifView)getView()).setNeedGifUrl(Intrinsics.areEqual("true", String.valueOf(paramObject)));
        }
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.ui.PTSNodeGif
 * JD-Core Version:    0.7.0.1
 */