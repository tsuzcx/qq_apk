import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/gldrawable/Utils;", "", "()V", "getHardwareDecodec", "Ljava/util/ArrayList;", "Landroid/media/MediaCodecInfo;", "Lkotlin/collections/ArrayList;", "mime", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class bhrl
{
  public static final bhrl a = new bhrl();
  
  @JvmStatic
  @NotNull
  public static final ArrayList<MediaCodecInfo> a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "mime");
    ArrayList localArrayList = new ArrayList();
    if (Build.VERSION.SDK_INT < 16) {
      return localArrayList;
    }
    label303:
    for (;;)
    {
      int i;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        Object localObject1 = localStringBuilder.append("MediaCodec support list:");
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "append(value)");
        StringsKt.appendln((StringBuilder)localObject1);
        int k = MediaCodecList.getCodecCount();
        i = 0;
        if (i < k)
        {
          localObject1 = MediaCodecList.getCodecInfoAt(i);
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "it");
          if (!((MediaCodecInfo)localObject1).isEncoder()) {
            break label303;
          }
          localObject1 = null;
          if (localObject1 != null)
          {
            Object localObject2 = localStringBuilder.append(((MediaCodecInfo)localObject1).getName());
            Intrinsics.checkExpressionValueIsNotNull(localObject2, "append(value)");
            StringsKt.appendln((StringBuilder)localObject2);
            localObject2 = localStringBuilder.append(Arrays.toString(((MediaCodecInfo)localObject1).getSupportedTypes()));
            Intrinsics.checkExpressionValueIsNotNull(localObject2, "append(value)");
            StringsKt.appendln((StringBuilder)localObject2);
            if (localObject1 != null)
            {
              localObject2 = ((MediaCodecInfo)localObject1).getName();
              Intrinsics.checkExpressionValueIsNotNull(localObject2, "info.name");
              if (!StringsKt.contains((CharSequence)localObject2, (CharSequence)".sw.", true))
              {
                localObject2 = ((MediaCodecInfo)localObject1).getName();
                Intrinsics.checkExpressionValueIsNotNull(localObject2, "info.name");
                if (!StringsKt.contains((CharSequence)localObject2, (CharSequence)".google.", true))
                {
                  String[] arrayOfString = ((MediaCodecInfo)localObject1).getSupportedTypes();
                  Intrinsics.checkExpressionValueIsNotNull(arrayOfString, "info.supportedTypes");
                  int m = arrayOfString.length;
                  int j = 0;
                  if (j < m)
                  {
                    localObject2 = arrayOfString[j];
                    if (StringsKt.equals((String)localObject2, paramString, true))
                    {
                      if (localObject2 != null) {
                        localArrayList.add(localObject1);
                      }
                    }
                    else {
                      j += 1;
                    }
                  }
                  else
                  {
                    localObject2 = null;
                    continue;
                  }
                }
              }
            }
          }
        }
        else
        {
          return localArrayList;
        }
      }
      catch (Throwable paramString) {}
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhrl
 * JD-Core Version:    0.7.0.1
 */