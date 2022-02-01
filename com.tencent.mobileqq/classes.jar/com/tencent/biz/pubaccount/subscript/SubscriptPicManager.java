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
    if ((paramObject != null) && ((paramObject instanceof String))) {}
    for (;;)
    {
      try
      {
        paramObject = URLDrawableHelper.getDrawable((String)paramObject, paramInt1, paramInt2);
        if (paramObject != null) {
          break label74;
        }
        return;
      }
      catch (IllegalArgumentException paramObject)
      {
        if (QLog.isColorLevel()) {
          QLog.i("SubscriptPicManager", 2, paramObject.toString());
        }
        paramObject = null;
        continue;
      }
      if ((paramObject != null) && ((paramObject instanceof URL)))
      {
        paramObject = URLDrawableHelper.getDrawable((URL)paramObject, paramInt1, paramInt2);
        continue;
        label74:
        if (paramObject.getStatus() != 1)
        {
          paramImageView.setTag(2131378707, paramObject.getURL());
          SubscriptPicManager.DrawableProperty localDrawableProperty = new SubscriptPicManager.DrawableProperty(this, null);
          localDrawableProperty.a = new WeakReference(paramImageView);
          localDrawableProperty.b = new WeakReference(paramImageHostListener);
          this.a.put(paramObject, localDrawableProperty);
          paramObject.setURLDrawableListener(this);
        }
        paramImageView.setImageDrawable(null);
        paramImageView.setImageDrawable(paramObject);
      }
      else
      {
        paramObject = null;
      }
    }
  }
  
  public void a(Object paramObject, ImageView paramImageView, int paramInt1, int paramInt2, SubscriptPicManager.ImageHostListener paramImageHostListener, int paramInt3)
  {
    if ((paramObject != null) && ((paramObject instanceof String))) {}
    for (;;)
    {
      try
      {
        paramObject = URLDrawableHelper.getDrawable((String)paramObject);
        if (paramObject != null) {
          break label68;
        }
        return;
      }
      catch (IllegalArgumentException paramObject)
      {
        if (QLog.isColorLevel()) {
          QLog.i("SubscriptPicManager", 2, paramObject.toString());
        }
        paramObject = null;
        continue;
      }
      if ((paramObject != null) && ((paramObject instanceof URL)))
      {
        paramObject = URLDrawableHelper.getDrawable((URL)paramObject);
        continue;
        label68:
        paramImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        if (paramObject.getStatus() != 1)
        {
          paramImageView.setTag(2131378707, paramObject.getURL());
          paramImageView.setTag(2131378701, Boolean.TRUE);
          paramImageView.setTag(2131378704, Integer.valueOf(paramInt1));
          paramImageView.setTag(2131378702, Integer.valueOf(paramInt2));
          paramImageView.setTag(2131378703, Integer.valueOf(paramInt3));
          SubscriptPicManager.DrawableProperty localDrawableProperty = new SubscriptPicManager.DrawableProperty(this, null);
          localDrawableProperty.a = new WeakReference(paramImageView);
          localDrawableProperty.b = new WeakReference(paramImageHostListener);
          this.a.put(paramObject, localDrawableProperty);
          paramObject.setURLDrawableListener(this);
        }
        paramObject.setTag(URLDrawableDecodeHandler.b(paramInt1, paramInt2, (int)(paramInt3 * DeviceInfoUtil.a())));
        paramObject.setDecodeHandler(URLDrawableDecodeHandler.j);
        paramImageView.setImageDrawable(null);
        paramImageView.setImageDrawable(paramObject);
      }
      else
      {
        paramObject = null;
      }
    }
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if ((this.a == null) || (paramURLDrawable == null)) {}
    Object localObject;
    ImageView localImageView;
    do
    {
      do
      {
        do
        {
          return;
          localObject = (SubscriptPicManager.DrawableProperty)this.a.get(paramURLDrawable);
        } while (localObject == null);
        this.a.remove(paramURLDrawable);
        localImageView = (ImageView)((SubscriptPicManager.DrawableProperty)localObject).a.get();
      } while ((localImageView == null) || (!paramURLDrawable.getURL().equals(localImageView.getTag(2131378707))));
      localObject = (SubscriptPicManager.ImageHostListener)((SubscriptPicManager.DrawableProperty)localObject).b.get();
    } while ((localObject != null) && (!((SubscriptPicManager.ImageHostListener)localObject).a(localImageView)));
    if ((localImageView.getTag(2131378701) != null) && (((Boolean)localImageView.getTag(2131378701)).booleanValue()))
    {
      paramURLDrawable.setTag(URLDrawableDecodeHandler.b(((Integer)localImageView.getTag(2131378704)).intValue(), ((Integer)localImageView.getTag(2131378702)).intValue(), (int)(((Integer)localImageView.getTag(2131378703)).intValue() * DeviceInfoUtil.a())));
      paramURLDrawable.setDecodeHandler(URLDrawableDecodeHandler.j);
    }
    localImageView.setImageDrawable(null);
    localImageView.setImageDrawable(paramURLDrawable);
    localImageView.setTag(2131378707, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptPicManager
 * JD-Core Version:    0.7.0.1
 */