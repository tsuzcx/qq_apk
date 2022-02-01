package com.github.henryye.nativeiv.comm;

import android.graphics.Bitmap.Config;
import androidx.annotation.AnyThread;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.github.henryye.nativeiv.bitmap.c;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class b
  implements com.github.henryye.nativeiv.bitmap.b<NativeBitmapStruct>
{
  private NativeImageJni a = new NativeImageJni();
  private HashMap<Integer, NativeImage> b = new HashMap();
  
  public b()
  {
    this.a.a();
  }
  
  public IBitmap<NativeBitmapStruct> a()
  {
    return new NativeImage(this.a, this);
  }
  
  @AnyThread
  public void a(NativeImage paramNativeImage)
  {
    if (paramNativeImage == null) {
      return;
    }
    try
    {
      this.b.put(Integer.valueOf(paramNativeImage.hashCode()), paramNativeImage);
      return;
    }
    finally {}
  }
  
  public boolean a(InputStream paramInputStream, Bitmap.Config paramConfig, c paramc)
  {
    return (paramc == c.b) || (paramc == c.a);
  }
  
  public void b()
  {
    this.a.b();
    LinkedList localLinkedList = new LinkedList();
    try
    {
      Iterator localIterator = this.b.values().iterator();
      while (localIterator.hasNext()) {
        localLinkedList.push((NativeImage)localIterator.next());
      }
      this.b.clear();
      localIterator = localLinkedList.iterator();
      while (localIterator.hasNext()) {
        ((NativeImage)localIterator.next()).recycle();
      }
      localLinkedList.clear();
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  @AnyThread
  public void b(NativeImage paramNativeImage)
  {
    if (paramNativeImage == null) {
      return;
    }
    try
    {
      this.b.remove(Integer.valueOf(paramNativeImage.hashCode()));
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.github.henryye.nativeiv.comm.b
 * JD-Core Version:    0.7.0.1
 */