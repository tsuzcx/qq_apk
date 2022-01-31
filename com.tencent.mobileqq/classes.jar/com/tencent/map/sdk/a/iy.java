package com.tencent.map.sdk.a;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.tencent.tencentmap.io.QStorageManager;
import com.tencent.tencentmap.mapsdk.maps.model.Tile;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.TileProvider;
import java.io.File;
import java.util.Hashtable;
import java.util.Map;

public final class iy
{
  public pf a;
  public Map<Integer, ix> b = new Hashtable(4);
  String c;
  private ja d;
  private Context e;
  private lw f;
  
  public iy(Context paramContext, lw paramlw)
  {
    this.e = paramContext;
    this.f = paramlw;
    this.a = paramlw.a;
    this.c = QStorageManager.getInstance(paramContext).getDataDir().getPath();
  }
  
  private static int a(Uri paramUri)
  {
    if (paramUri == null) {}
    do
    {
      return -1;
      paramUri = paramUri.getLastPathSegment();
    } while (paramUri == null);
    try
    {
      int i = Integer.parseInt(paramUri);
      return i;
    }
    catch (NumberFormatException paramUri)
    {
      or.b(Log.getStackTraceString(paramUri));
    }
    return -1;
  }
  
  private static int a(Uri paramUri, String paramString)
  {
    if (paramUri == null) {
      return -1;
    }
    paramUri = paramUri.getQueryParameter(paramString);
    try
    {
      int i = Integer.parseInt(paramUri);
      return i;
    }
    catch (NumberFormatException paramUri)
    {
      or.b(Log.getStackTraceString(paramUri));
    }
    return -1;
  }
  
  public final ix a(int paramInt)
  {
    "zl id:".concat(String.valueOf(paramInt));
    os.a();
    if (paramInt >= 0) {
      return (ix)this.b.get(Integer.valueOf(paramInt));
    }
    return null;
  }
  
  public final TileOverlay a(TileOverlayOptions paramTileOverlayOptions)
  {
    if (this.d == null) {
      this.d = new ja(this);
    }
    ja localja = this.d;
    Object localObject = null;
    TileProvider localTileProvider = paramTileOverlayOptions.getTileProvider();
    if (localTileProvider != null)
    {
      if (!(localTileProvider instanceof je)) {
        break label134;
      }
      localObject = new iz(localja.a, paramTileOverlayOptions);
    }
    for (;;)
    {
      paramTileOverlayOptions = localja.a;
      if ((localObject != null) && (((ix)localObject).i > 0))
      {
        "zl save tileOverlay:".concat(String.valueOf(localObject));
        new StringBuilder("id:").append(((ix)localObject).i).toString();
        os.a();
        paramTileOverlayOptions.b.put(Integer.valueOf(((ix)localObject).i), localObject);
      }
      return new TileOverlay((ix)localObject);
      label134:
      if ((localTileProvider instanceof ka)) {
        localObject = new jb(localja.a, paramTileOverlayOptions);
      } else {
        localObject = new ix(localja.a, paramTileOverlayOptions);
      }
    }
  }
  
  final void a(int paramInt1, int paramInt2)
  {
    if (this.a == null) {
      return;
    }
    this.a.b(paramInt1, paramInt2);
  }
  
  public final byte[] a(String paramString)
  {
    Object localObject2;
    try
    {
      Object localObject1 = Uri.parse(paramString);
      if (!nl.a(((Uri)localObject1).getAuthority(), "getTile")) {
        return null;
      }
      int i = a((Uri)localObject1);
      if (i == -1) {
        return null;
      }
      paramString = (ix)this.b.get(Integer.valueOf(i));
      if (paramString == null) {
        return null;
      }
      i = a((Uri)localObject1, "x");
      int j = a((Uri)localObject1, "y");
      int k = a((Uri)localObject1, "z");
      if ((paramString.l == null) || (paramString.l.getTileProvider() == null) || (k < 0))
      {
        or.b("TileOverlay", "无效坐标，返回空瓦块");
        return fy.a();
      }
      localObject1 = om.b(paramString.l.getVersionInfo());
      localObject1 = String.format(ix.h, new Object[] { localObject1, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      localObject2 = paramString.l.getTileProvider().getTile(i, j, k);
      if (localObject2 == null)
      {
        or.b("TileOverlay", "Provider没有瓦片数据，返回空瓦块");
        return fy.a();
      }
      localObject2 = ((Tile)localObject2).mData;
      if ((localObject2 != null) && (localObject2.length > 0))
      {
        "put to cache of cacheId:".concat(String.valueOf(localObject1));
        os.a();
        iu localiu = new iu((byte[])localObject2);
        if (paramString.m != null)
        {
          oh localoh = oc.a(paramString.m);
          if (localoh != null) {
            localoh.b((String)localObject1, localiu);
          } else {
            paramString.m.a((String)localObject1, localiu);
          }
        }
      }
    }
    catch (Exception paramString)
    {
      or.b(Log.getStackTraceString(paramString));
      return null;
    }
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.iy
 * JD-Core Version:    0.7.0.1
 */