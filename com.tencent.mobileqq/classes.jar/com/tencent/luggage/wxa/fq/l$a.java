package com.tencent.luggage.wxa.fq;

import android.content.SharedPreferences.Editor;
import android.os.FileObserver;
import com.tencent.luggage.wxa.qz.w;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/wxaapi/internal/WxaDynamicPkgMgr$initLoadLibrary$2", "Landroid/os/FileObserver;", "onEvent", "", "event", "", "path", "", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class l$a
  extends FileObserver
{
  l$a(String paramString, int paramInt)
  {
    super(paramInt, i);
  }
  
  public void onEvent(int paramInt, @Nullable String paramString)
  {
    l locall = l.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FileObserver event:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" path:");
    localStringBuilder.append(paramString);
    l.a(locall, localStringBuilder.toString());
    if ((paramInt != 2) && (paramInt != 512)) {
      return;
    }
    if (paramString != null)
    {
      paramString = l.b(l.a, paramString);
      l.b(l.a).remove(paramString).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fq.l.a
 * JD-Core Version:    0.7.0.1
 */