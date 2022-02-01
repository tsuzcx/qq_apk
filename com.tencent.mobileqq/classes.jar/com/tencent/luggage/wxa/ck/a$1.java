package com.tencent.luggage.wxa.ck;

import android.content.Intent;
import com.tencent.luggage.util.LuggageActivityHelper.ActivityResultCallback;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.FilenameUtils;

class a$1
  implements LuggageActivityHelper.ActivityResultCallback
{
  a$1(a parama, c paramc, int paramInt) {}
  
  public void onResult(int paramInt, Intent paramIntent)
  {
    Object localObject = com.tencent.image_picker.imagepicker.features.b.a(paramIntent);
    if (localObject == null)
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsApiChooseImage", "chooseImage onActivityResult get NULL images, resultCode=%d, appId=%s", new Object[] { Integer.valueOf(paramInt), this.a.getAppId() });
      this.a.a(this.b, this.c.b("fail cancel"));
      return;
    }
    paramIntent = new ArrayList(((List)localObject).size());
    ArrayList localArrayList = new ArrayList(((List)localObject).size());
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.luggage.wxa.az.b localb = (com.tencent.luggage.wxa.az.b)((Iterator)localObject).next();
      com.tencent.luggage.wxa.rt.i locali = new com.tencent.luggage.wxa.rt.i(localb.a());
      com.tencent.luggage.wxa.pc.i locali1 = new com.tencent.luggage.wxa.pc.i();
      if (this.a.getFileSystem().a(locali, FilenameUtils.getExtension(localb.a()), false, locali1) == j.a)
      {
        paramIntent.add(locali1.a);
        localArrayList.add(Long.valueOf(locali.q()));
      }
    }
    localObject = new HashMap();
    ((HashMap)localObject).put("tempFilePaths", a.a(paramIntent));
    ((HashMap)localObject).put("tempFileSizes", a.a(localArrayList));
    this.a.a(this.b, this.c.a("ok", (Map)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ck.a.1
 * JD-Core Version:    0.7.0.1
 */