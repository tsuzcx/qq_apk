package com.tencent.map.sdk.engine.jni;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.Typeface;
import com.tencent.map.sdk.a.ke;
import com.tencent.map.sdk.a.ma;
import com.tencent.map.sdk.a.me;
import com.tencent.map.sdk.a.mf;
import com.tencent.map.sdk.a.mg;
import com.tencent.map.sdk.a.mh;
import com.tencent.map.sdk.a.mi;
import com.tencent.map.sdk.a.mj;
import com.tencent.map.sdk.a.mk;
import com.tencent.map.sdk.a.ml;
import com.tencent.map.sdk.a.nl;
import com.tencent.map.sdk.a.or;
import com.tencent.map.sdk.a.os;
import com.tencent.map.sdk.a.pb;
import com.tencent.map.sdk.a.qd;
import com.tencent.map.sdk.a.qh;
import com.tencent.map.sdk.engine.jni.models.DataSource;
import com.tencent.map.sdk.engine.jni.models.IconImageInfo;
import com.tencent.map.sdk.engine.jni.models.MapTileID;
import com.tencent.map.sdk.engine.jni.models.TextBitmapInfo;
import java.util.Hashtable;

public class JNICallback
{
  private ke a;
  private mf b;
  private me c;
  private mk d;
  private mi e;
  private ml f;
  private mg g;
  private mj h;
  private mh i;
  private ma j;
  private Hashtable<Long, Paint> k = new Hashtable();
  private Hashtable<Long, PointF> l = new Hashtable();
  private Bitmap m = null;
  public TextBitmapInfo mTextBitmapInfo = null;
  
  public JNICallback(ke paramke, mf parammf, me paramme, mk parammk, mg parammg, mj parammj, ma paramma, ml paramml, mi parammi)
  {
    this.a = paramke;
    this.b = parammf;
    this.c = paramme;
    this.d = parammk;
    this.f = paramml;
    this.g = parammg;
    this.e = parammi;
    this.h = parammj;
    this.j = paramma;
    this.m = Bitmap.createBitmap(800, 400, Bitmap.Config.ALPHA_8);
    this.mTextBitmapInfo = new TextBitmapInfo();
  }
  
  private Paint a()
  {
    Hashtable localHashtable = this.k;
    if (localHashtable == null) {
      return null;
    }
    return (Paint)localHashtable.get(Long.valueOf(Thread.currentThread().getId()));
  }
  
  private Paint a(int paramInt)
  {
    Paint localPaint = a();
    Object localObject = localPaint;
    if (localPaint == null)
    {
      localObject = new pb();
      ((Paint)localObject).setTypeface(Typeface.DEFAULT);
      ((Paint)localObject).setAntiAlias(true);
      ((Paint)localObject).setStyle(Paint.Style.FILL);
      ((Paint)localObject).setTextAlign(Paint.Align.CENTER);
      ((Paint)localObject).setLinearText(true);
      a((Paint)localObject);
    }
    ((Paint)localObject).setTextAlign(Paint.Align.CENTER);
    ((Paint)localObject).setTextSize(paramInt);
    return localObject;
  }
  
  private IconImageInfo a(int paramInt, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == 0) {
        return null;
      }
      try
      {
        paramArrayOfByte = new String(paramArrayOfByte);
        if (paramInt == 1)
        {
          ke localke = this.a;
          IconImageInfo localIconImageInfo = new IconImageInfo();
          localIconImageInfo.scale = localke.c;
          localIconImageInfo.anchorPointX1 = 0.5F;
          localIconImageInfo.anchorPointY1 = 0.5F;
          localIconImageInfo.bitmap = localke.a(paramArrayOfByte, Bitmap.Config.RGB_565);
          return localIconImageInfo;
        }
        paramArrayOfByte = this.a.a(paramArrayOfByte);
        return paramArrayOfByte;
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
    return null;
  }
  
  private void a(Paint paramPaint)
  {
    Hashtable localHashtable = this.k;
    if (localHashtable != null) {
      localHashtable.put(Long.valueOf(Thread.currentThread().getId()), paramPaint);
    }
  }
  
  public Object callback(int paramInt, JNIEvent paramJNIEvent)
  {
    boolean bool = true;
    Object localObject2 = null;
    Object localObject1 = null;
    Object localObject3;
    float f1;
    switch (paramInt)
    {
    default: 
      return null;
    case 10: 
      os.a();
      localObject1 = localObject2;
      if (!nl.a(paramJNIEvent.name))
      {
        localObject3 = new qd();
        ((qd)localObject3).a = paramJNIEvent.id;
        if ((paramJNIEvent.extra instanceof MapTileID))
        {
          localObject1 = (MapTileID)paramJNIEvent.extra;
          ((qd)localObject3).b = ((MapTileID)localObject1).getDataSource().getValue();
          ((qd)localObject3).c = ((MapTileID)localObject1).getPriority().e;
        }
        ((qd)localObject3).d = paramJNIEvent.extra;
        paramJNIEvent = paramJNIEvent.name;
        localObject1 = localObject2;
        if (this.c != null)
        {
          or.a("Engine callback cancel download:".concat(String.valueOf(paramJNIEvent)));
          this.c.a(paramJNIEvent, (qd)localObject3);
          return null;
        }
      }
      break;
    case 9: 
      localObject3 = this.h;
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        if (paramJNIEvent.id <= 0) {
          bool = false;
        }
        ((mj)localObject3).a(bool);
        return null;
      }
      break;
    case 8: 
      paramJNIEvent = this.g;
      localObject1 = localObject2;
      if (paramJNIEvent != null)
      {
        paramJNIEvent.b();
        return null;
      }
      break;
    case 7: 
      localObject3 = this.j;
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        ((ma)localObject3).c(paramJNIEvent.name);
        return null;
      }
      break;
    case 6: 
      paramJNIEvent = this.f;
      localObject1 = localObject2;
      if (paramJNIEvent != null)
      {
        paramJNIEvent.a();
        return null;
      }
      break;
    case 5: 
      localObject3 = paramJNIEvent.name;
      paramJNIEvent = paramJNIEvent.data;
      localObject1 = localObject2;
      if (paramJNIEvent != null)
      {
        new JNICallback.1(this, (String)localObject3, paramJNIEvent).execute(new Void[0]);
        return null;
      }
      break;
    case 4: 
      return a(paramJNIEvent.id, paramJNIEvent.data);
    case 3: 
      os.a();
      localObject1 = localObject2;
      if (!nl.a(paramJNIEvent.name))
      {
        localObject3 = new qd();
        ((qd)localObject3).a = paramJNIEvent.id;
        if ((paramJNIEvent.extra instanceof MapTileID))
        {
          localObject1 = (MapTileID)paramJNIEvent.extra;
          ((qd)localObject3).b = ((MapTileID)localObject1).getDataSource().getValue();
          ((qd)localObject3).c = ((MapTileID)localObject1).getPriority().e;
        }
        ((qd)localObject3).d = paramJNIEvent.extra;
        paramJNIEvent = paramJNIEvent.name;
        localObject1 = localObject2;
        if (this.b != null)
        {
          or.a("Engine callback download:".concat(String.valueOf(paramJNIEvent)));
          this.b.b(paramJNIEvent, (qd)localObject3);
          return null;
        }
      }
      break;
    case 2: 
      localObject2 = paramJNIEvent.name;
      paramInt = paramJNIEvent.id;
      f1 = a(paramInt).measureText((String)localObject2);
      paramJNIEvent = this.l;
      if (paramJNIEvent == null) {
        paramJNIEvent = (JNIEvent)localObject1;
      } else {
        paramJNIEvent = (PointF)paramJNIEvent.get(Long.valueOf(Thread.currentThread().getId()));
      }
      localObject1 = paramJNIEvent;
      if (paramJNIEvent == null)
      {
        localObject1 = new PointF();
        paramJNIEvent = this.l;
        if (paramJNIEvent != null) {
          paramJNIEvent.put(Long.valueOf(Thread.currentThread().getId()), localObject1);
        }
      }
      ((PointF)localObject1).x = (f1 + 1.0F);
      ((PointF)localObject1).y = (paramInt + 2);
      return localObject1;
    case 1: 
      paramInt = paramJNIEvent.id;
      localObject1 = paramJNIEvent.name;
      paramJNIEvent = paramJNIEvent.data;
      if (this.m == null) {
        this.m = Bitmap.createBitmap(800, 400, Bitmap.Config.ALPHA_8);
      }
      if (this.m == null) {
        return null;
      }
      this.mTextBitmapInfo.fill(paramJNIEvent);
      paramJNIEvent = a(paramInt);
      this.m.eraseColor(0);
      localObject2 = new Canvas(this.m);
      f1 = (paramJNIEvent.descent() + paramJNIEvent.ascent()) / 2.0F;
      paramJNIEvent.setFakeBoldText(this.mTextBitmapInfo.bold);
      ((Canvas)localObject2).drawText((String)localObject1, 400.0F, 200.0F - f1, paramJNIEvent);
      localObject1 = this.m;
    }
    return localObject1;
  }
  
  public int callbackGetGLContext()
  {
    mh localmh = this.i;
    if (localmh != null) {
      return localmh.getEGLContextHash();
    }
    return 0;
  }
  
  public void destory()
  {
    this.m = null;
    this.mTextBitmapInfo = null;
    Hashtable localHashtable = this.k;
    if (localHashtable != null)
    {
      localHashtable.clear();
      this.k = null;
    }
    localHashtable = this.l;
    if (localHashtable != null)
    {
      localHashtable.clear();
      this.l = null;
    }
    this.a = null;
    this.b = null;
    this.c = null;
    this.f = null;
    this.g = null;
    this.e = null;
  }
  
  public void onMapCameraChangeStopped()
  {
    mi localmi = this.e;
    if (localmi != null) {
      localmi.j();
    }
  }
  
  public void onMapCameraChanged()
  {
    mi localmi = this.e;
    if (localmi != null) {
      localmi.i();
    }
  }
  
  public void onMapLoaded()
  {
    mk localmk = this.d;
    if (localmk != null) {
      localmk.e();
    }
  }
  
  public void setMapCallbackGetGLContext(mh parammh)
  {
    this.i = parammh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.engine.jni.JNICallback
 * JD-Core Version:    0.7.0.1
 */