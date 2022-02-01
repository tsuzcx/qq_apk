package com.tencent.biz.pubaccount.readinjoy.pts.ui;

import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.ui.vnode.PTSNodeVirtual;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/pts/ui/PTSNodeVideo;", "Lcom/tencent/pts/ui/vnode/PTSNodeVirtual;", "Lcom/tencent/biz/pubaccount/readinjoy/pts/ui/PTSVideoView;", "appInstance", "Lcom/tencent/pts/core/PTSAppInstance;", "(Lcom/tencent/pts/core/PTSAppInstance;)V", "setAttribute", "", "key", "", "value", "", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class PTSNodeVideo
  extends PTSNodeVirtual<PTSVideoView>
{
  public static final PTSNodeVideo.Companion Companion = new PTSNodeVideo.Companion(null);
  @NotNull
  public static final String VIDEO_TAG = "PTSNodeVideo";
  
  public PTSNodeVideo(@NotNull PTSAppInstance paramPTSAppInstance)
  {
    super(paramPTSAppInstance);
  }
  
  public boolean setAttribute(@Nullable String paramString, @Nullable Object paramObject)
  {
    QLog.d("PTSNodeVideo", 1, "key:" + paramString + ",value:" + paramObject);
    if (paramString == null) {}
    Object localObject1;
    int i;
    do
    {
      do
      {
        for (;;)
        {
          return super.setAttribute(paramString, paramObject);
          switch (paramString.hashCode())
          {
          default: 
            break;
          case -1973458181: 
            if (paramString.equals("pts-video:auto-play-mode"))
            {
              localObject1 = StringsKt.toIntOrNull(String.valueOf(paramObject));
              if (localObject1 != null)
              {
                i = ((Number)localObject1).intValue();
                localObject1 = (PTSVideoView)getView();
                Intrinsics.checkExpressionValueIsNotNull(localObject1, "view");
                ((PTSVideoView)localObject1).setPlayMode(i);
              }
            }
            break;
          case -1379994278: 
            if (paramString.equals("pts-video:scale-type"))
            {
              localObject1 = StringsKt.toIntOrNull(String.valueOf(paramObject));
              if (localObject1 != null)
              {
                i = ((Number)localObject1).intValue();
                ((PTSVideoView)getView()).setScaleType(i);
              }
            }
            break;
          case 1780884992: 
            if (paramString.equals("pts-video:video-url"))
            {
              localObject1 = (PTSVideoView)getView();
              Intrinsics.checkExpressionValueIsNotNull(localObject1, "view");
              ((PTSVideoView)localObject1).setVideoUrl(String.valueOf(paramObject));
            }
            break;
          case 608867309: 
            if (paramString.equals("pts-video:auto-play-percent")) {
              QLog.d("PTSNodeVideo", 1, "auto-play-percent not supported!");
            }
            break;
          case -1474806401: 
            if (paramString.equals("pts-video:play-mode"))
            {
              localObject1 = StringsKt.toIntOrNull(String.valueOf(paramObject));
              if (localObject1 != null)
              {
                i = ((Number)localObject1).intValue();
                localObject1 = (PTSVideoView)getView();
                Intrinsics.checkExpressionValueIsNotNull(localObject1, "view");
                ((PTSVideoView)localObject1).setPlayMode(i);
              }
            }
            break;
          case 1784527364: 
            if (paramString.equals("pts-video:report-json")) {
              ((PTSVideoView)getView()).setReportR5(String.valueOf(paramObject));
            }
            break;
          case 585958230: 
            if (paramString.equals("pts-video:mute"))
            {
              localObject1 = (PTSVideoView)getView();
              Intrinsics.checkExpressionValueIsNotNull(localObject1, "view");
              ((PTSVideoView)localObject1).setMute(Intrinsics.areEqual("true", String.valueOf(paramObject)));
            }
            break;
          }
        }
      } while (!paramString.equals("pts-video:icon-size"));
      localObject1 = StringsKt.split$default((CharSequence)String.valueOf(paramObject), new String[] { " " }, false, 0, 6, null);
    } while (((List)localObject1).size() != 2);
    Object localObject2 = StringsKt.toIntOrNull((String)((List)localObject1).get(0));
    if (localObject2 != null)
    {
      i = ((Number)localObject2).intValue();
      label520:
      localObject1 = StringsKt.toIntOrNull((String)((List)localObject1).get(1));
      if (localObject1 == null) {
        break label807;
      }
    }
    label807:
    for (int j = ((Number)localObject1).intValue(); (i != -1) && (j != -1); j = -1)
    {
      ((PTSVideoView)getView()).setPlayIconSize(i, j);
      ((PTSVideoView)getView()).setPlayIconVisible(true);
      break;
      if (!paramString.equals("pts-video:will-repeat")) {
        break;
      }
      ((PTSVideoView)getView()).setLoop(Intrinsics.areEqual("true", String.valueOf(paramObject)));
      break;
      if (!paramString.equals("pts-video:video-id-type")) {
        break;
      }
      localObject2 = StringsKt.split$default((CharSequence)String.valueOf(paramObject), new String[] { " " }, false, 0, 6, null);
      if (((List)localObject2).size() != 2) {
        break;
      }
      localObject1 = (String)((List)localObject2).get(0);
      localObject2 = (String)((List)localObject2).get(1);
      PTSVideoView localPTSVideoView = (PTSVideoView)getView();
      Intrinsics.checkExpressionValueIsNotNull(localPTSVideoView, "view");
      localPTSVideoView.setVideoVid((String)localObject1);
      localObject1 = StringsKt.toIntOrNull((String)localObject2);
      if (localObject1 == null) {
        break;
      }
      i = ((Number)localObject1).intValue();
      ((PTSVideoView)getView()).setVideoBusiType(i);
      break;
      if (!paramString.equals("pts-video:cover-url")) {
        break;
      }
      ((PTSVideoView)getView()).setCoverUrl(String.valueOf(paramObject));
      break;
      if (!paramString.equals("pts-video:icon-url")) {
        break;
      }
      ((PTSVideoView)getView()).setPlayIconUrl(String.valueOf(paramObject));
      break;
      i = -1;
      break label520;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.ui.PTSNodeVideo
 * JD-Core Version:    0.7.0.1
 */