package com.tencent.mm.appbrand.v8;

import android.content.Context;
import com.eclipsesource.mmv8.MultiContextNodeJS.IGetTmpFileDirectory;
import com.tencent.luggage.wxa.gl.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import java.io.File;

final class i$1
  implements MultiContextNodeJS.IGetTmpFileDirectory
{
  public File getDirectory()
  {
    Object localObject1 = r.a();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(((Context)localObject1).getFilesDir().getParentFile().getAbsolutePath());
    ((StringBuilder)localObject2).append("/MicroMsg/tmp/");
    localObject1 = ((StringBuilder)localObject2).toString();
    a.a(new String[] { localObject1 });
    localObject2 = new com.tencent.luggage.wxa.rt.i((String)localObject1);
    if (!((com.tencent.luggage.wxa.rt.i)localObject2).j())
    {
      o.b("MicroMsg.NodeJSRuntime", "try mkdirs again");
      ((com.tencent.luggage.wxa.rt.i)localObject2).u();
    }
    o.d("MicroMsg.NodeJSRuntime", "tmpDir:%s exist:%b", new Object[] { localObject1, Boolean.valueOf(((com.tencent.luggage.wxa.rt.i)localObject2).j()) });
    return new File(com.tencent.luggage.wxa.gl.i.a(((com.tencent.luggage.wxa.rt.i)localObject2).l(), true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.i.1
 * JD-Core Version:    0.7.0.1
 */