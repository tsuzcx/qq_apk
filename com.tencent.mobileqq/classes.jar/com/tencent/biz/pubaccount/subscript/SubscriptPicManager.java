package com.tencent.biz.pubaccount.subscript;

import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.HashMap;

public class SubscriptPicManager
  implements URLDrawable.URLDrawableListener
{
  private HashMap<URLDrawable, SubscriptPicManager.DrawableProperty> a = new HashMap();
  
  public void a()
  {
    this.a.clear();
    this.a = null;
  }
  
  public void a(Object paramObject, ImageView paramImageView, int paramInt1, int paramInt2, SubscriptPicManager.ImageHostListener paramImageHostListener)
  {
    if ((paramObject != null) && ((paramObject instanceof String)))
    {
      try
      {
        paramObject = URLDrawableHelper.getDrawable((String)paramObject, paramInt1, paramInt2);
      }
      catch (IllegalArgumentException paramObject)
      {
        if (!QLog.isColorLevel()) {
          break label70;
        }
      }
      QLog.i("SubscriptPicManager", 2, paramObject.toString());
    }
    else if ((paramObject != null) && ((paramObject instanceof URL)))
    {
      paramObject = URLDrawableHelper.getDrawable((URL)paramObject, paramInt1, paramInt2);
      break label72;
    }
    label70:
    paramObject = null;
    label72:
    if (paramObject == null) {
      return;
    }
    if (paramObject.getStatus() != 1)
    {
      paramImageView.setTag(2131378102, paramObject.getURL());
      SubscriptPicManager.DrawableProperty localDrawableProperty = new SubscriptPicManager.DrawableProperty(this, null);
      localDrawableProperty.a = new WeakReference(paramImageView);
      localDrawableProperty.b = new WeakReference(paramImageHostListener);
      this.a.put(paramObject, localDrawableProperty);
      paramObject.setURLDrawableListener(this);
    }
    paramImageView.setImageDrawable(null);
    paramImageView.setImageDrawable(paramObject);
  }
  
  public void a(Object paramObject, ImageView paramImageView, int paramInt1, int paramInt2, SubscriptPicManager.ImageHostListener paramImageHostListener, int paramInt3)
  {
    if ((paramObject != null) && ((paramObject instanceof String)))
    {
      try
      {
        paramObject = URLDrawableHelper.getDrawable((String)paramObject);
      }
      catch (IllegalArgumentException paramObject)
      {
        if (!QLog.isColorLevel()) {
          break label64;
        }
      }
      QLog.i("SubscriptPicManager", 2, paramObject.toString());
    }
    else if ((paramObject != null) && ((paramObject instanceof URL)))
    {
      paramObject = URLDrawableHelper.getDrawable((URL)paramObject);
      break label66;
    }
    label64:
    paramObject = null;
    label66:
    if (paramObject == null) {
      return;
    }
    paramImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    if (paramObject.getStatus() != 1)
    {
      paramImageView.setTag(2131378102, paramObject.getURL());
      paramImageView.setTag(2131378096, Boolean.TRUE);
      paramImageView.setTag(2131378099, Integer.valueOf(paramInt1));
      paramImageView.setTag(2131378097, Integer.valueOf(paramInt2));
      paramImageView.setTag(2131378098, Integer.valueOf(paramInt3));
      SubscriptPicManager.DrawableProperty localDrawableProperty = new SubscriptPicManager.DrawableProperty(this, null);
      localDrawableProperty.a = new WeakReference(paramImageView);
      localDrawableProperty.b = new WeakReference(paramImageHostListener);
      this.a.put(paramObject, localDrawableProperty);
      paramObject.setURLDrawableListener(this);
    }
    paramObject.setTag(URLDrawableDecodeHandler.b(paramInt1, paramInt2, (int)(paramInt3 * DeviceInfoUtil.a())));
    paramObject.setDecodeHandler(URLDrawableDecodeHandler.i);
    paramImageView.setImageDrawable(null);
    paramImageView.setImageDrawable(paramObject);
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    Object localObject1 = this.a;
    if (localObject1 != null)
    {
      if (paramURLDrawable == null) {
        return;
      }
      Object localObject2 = (SubscriptPicManager.DrawableProperty)((HashMap)localObject1).get(paramURLDrawable);
      if (localObject2 == null) {
        return;
      }
      this.a.remove(paramURLDrawable);
      localObject1 = (ImageView)((SubscriptPicManager.DrawableProperty)localObject2).a.get();
      if (localObject1 != null)
      {
        if (!paramURLDrawable.getURL().equals(((ImageView)localObject1).getTag(2131378102))) {
          return;
        }
        localObject2 = (SubscriptPicManager.ImageHostListener)((SubscriptPicManager.DrawableProperty)localObject2).b.get();
        if ((localObject2 == null) || (((SubscriptPicManager.ImageHostListener)localObject2).a((ImageView)localObject1)))
        {
          if ((((ImageView)localObject1).getTag(2131378096) != null) && (((Boolean)((ImageView)localObject1).getTag(2131378096)).booleanValue()))
          {
            paramURLDrawable.setTag(URLDrawableDecodeHandler.b(((Integer)((ImageView)localObject1).getTag(2131378099)).intValue(), ((Integer)((ImageView)localObject1).getTag(2131378097)).intValue(), (int)(((Integer)((ImageView)localObject1).getTag(2131378098)).intValue() * DeviceInfoUtil.a())));
            paramURLDrawable.setDecodeHandler(URLDrawableDecodeHandler.i);
          }
          ((ImageView)localObject1).setImageDrawable(null);
          ((ImageView)localObject1).setImageDrawable(paramURLDrawable);
          ((ImageView)localObject1).setTag(2131378102, null);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptPicManager
 * JD-Core Version:    0.7.0.1
 */