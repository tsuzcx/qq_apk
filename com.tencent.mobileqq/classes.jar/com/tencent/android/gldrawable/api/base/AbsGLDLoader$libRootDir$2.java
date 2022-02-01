package com.tencent.android.gldrawable.api.base;

import android.app.Application;
import com.tencent.android.gldrawable.api.ILoadUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Ljava/io/File;", "invoke"}, k=3, mv={1, 1, 16})
final class AbsGLDLoader$libRootDir$2
  extends Lambda
  implements Function0<File>
{
  AbsGLDLoader$libRootDir$2(AbsGLDLoader paramAbsGLDLoader)
  {
    super(0);
  }
  
  @NotNull
  public final File invoke()
  {
    return new File(this.this$0.getLoaderUtils().getApplication().getFilesDir(), "gldrawablelib");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.android.gldrawable.api.base.AbsGLDLoader.libRootDir.2
 * JD-Core Version:    0.7.0.1
 */