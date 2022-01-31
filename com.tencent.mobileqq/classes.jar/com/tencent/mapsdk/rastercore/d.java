package com.tencent.mapsdk.rastercore;

import android.content.Context;
import android.os.AsyncTask;
import com.tencent.mapsdk.rastercore.d.e;
import com.tencent.mapsdk.rastercore.d.h;
import com.tencent.mapsdk.rastercore.tile.MapTile.MapSource;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d
{
  private b a;
  private String b;
  
  public d(Context paramContext, a parama)
  {
    paramContext = com.tencent.mapsdk.rastercore.f.b.a(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://overseactrl.map.qq.com/?apikey=");
    localStringBuilder.append(paramContext);
    localStringBuilder.append("&ver=");
    localStringBuilder.append("1.3.1.3");
    localStringBuilder.append("&ctrlpf=grid");
    localStringBuilder.append("&ctrlmb=and");
    localStringBuilder.append("&ctrlver=");
    localStringBuilder.append(h.i());
    localStringBuilder.append("&frontier=");
    localStringBuilder.append(com.tencent.mapsdk.rastercore.f.a.a().b(""));
    this.b = localStringBuilder.toString();
    this.a = new b(parama);
  }
  
  private boolean a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return false;
    }
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.optInt("error", -2147483648) != 0)
      {
        h.a(false);
        com.tencent.mapsdk.rastercore.f.a.a().a("world_map_enable", false);
        paramString = paramString.getJSONObject("info").getJSONArray("detail").toString();
        com.tencent.mapsdk.rastercore.f.a.a().a("world_map_logo_change_rule_json", paramString);
        h.a(paramString);
        return true;
      }
      h.a(true);
      com.tencent.mapsdk.rastercore.f.a.a().a("world_map_enable", true);
      paramString = paramString.getJSONObject("info");
      Object localObject = paramString.optJSONObject("frontier");
      int j;
      if (localObject != null)
      {
        localObject = ((JSONObject)localObject).optString("path");
        if ((localObject != null) && (((String)localObject).length() != 0)) {}
      }
      else
      {
        j = paramString.getInt("version");
        i = h.i();
        if (j == i) {
          break label289;
        }
      }
      label289:
      for (int i = 1;; i = 0)
      {
        for (;;)
        {
          if (i != 0) {
            break label294;
          }
          return false;
          try
          {
            localObject = (HttpURLConnection)new URL((String)localObject).openConnection();
            ((HttpURLConnection)localObject).setRequestProperty("Accept-Encoding", "gzip");
            if (((HttpURLConnection)localObject).getResponseCode() != 200) {
              break;
            }
            String str = ((HttpURLConnection)localObject).getHeaderField("Content-Encoding");
            if ((str != null) && (str.length() > 0)) {
              str.toLowerCase().contains("gzip");
            }
            localObject = new String(c.a(new GZIPInputStream(((HttpURLConnection)localObject).getInputStream())));
            e.a();
            i = e.b((String)localObject);
            com.tencent.mapsdk.rastercore.f.a.a().a("", i);
            e.a().a((String)localObject);
          }
          catch (Throwable localThrowable) {}
        }
        break;
      }
      label294:
      h.m();
      JSONObject localJSONObject = paramString.getJSONObject("tilesrc");
      i = localJSONObject.optInt("style", 1000);
      int k = localJSONObject.optInt("scene", 0);
      int m = localJSONObject.optInt("version", b.e);
      if (m != h.g()) {
        com.tencent.mapsdk.rastercore.tile.a.a.a().a(MapTile.MapSource.WORLD);
      }
      paramString = paramString.getJSONArray("detail").toString();
      h.a(k, i, m, j, null, paramString);
      com.tencent.mapsdk.rastercore.f.a.a().a("world_map_tile_url_regex", null);
      com.tencent.mapsdk.rastercore.f.a.a().a("world_map_version", m);
      com.tencent.mapsdk.rastercore.f.a.a().a("world_map_style", i);
      com.tencent.mapsdk.rastercore.f.a.a().a("world_map_scene", k);
      com.tencent.mapsdk.rastercore.f.a.a().a("world_map_logo_change_rule_json", paramString);
      com.tencent.mapsdk.rastercore.f.a.a().a("world_map_protocol_version", j);
      return true;
    }
    catch (Throwable paramString)
    {
      com.tencent.mapsdk.rastercore.f.a.a().a("world_map_protocol_version", 0);
    }
    return false;
  }
  
  public final void a()
  {
    this.a.execute(new String[] { this.b });
  }
  
  public static abstract interface a
  {
    public abstract void b(boolean paramBoolean);
  }
  
  final class b
    extends AsyncTask<String, Void, Boolean>
  {
    private WeakReference<d.a> a;
    
    public b(d.a parama)
    {
      this.a = new WeakReference(parama);
    }
    
    private Boolean a(String... paramVarArgs)
    {
      if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
      for (;;)
      {
        try
        {
          paramVarArgs = (HttpURLConnection)new URL(paramVarArgs[0]).openConnection();
          paramVarArgs.setRequestProperty("Accept-Encoding", "gzip");
          if (paramVarArgs.getResponseCode() == 200)
          {
            String str = paramVarArgs.getHeaderField("Content-Encoding");
            if ((str != null) && (str.length() > 0) && (str.toLowerCase().contains("gzip")))
            {
              i = 1;
              if (i != 0)
              {
                paramVarArgs = new GZIPInputStream(paramVarArgs.getInputStream());
                paramVarArgs = new String(c.a(paramVarArgs));
                return Boolean.valueOf(d.a(d.this, paramVarArgs));
              }
              paramVarArgs = paramVarArgs.getInputStream();
              continue;
            }
          }
          else
          {
            return Boolean.valueOf(false);
          }
        }
        catch (Throwable paramVarArgs) {}
        int i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.d
 * JD-Core Version:    0.7.0.1
 */