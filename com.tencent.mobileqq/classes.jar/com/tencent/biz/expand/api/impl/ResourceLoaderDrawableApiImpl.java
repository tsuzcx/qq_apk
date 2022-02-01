package com.tencent.biz.expand.api.impl;

import com.qflutter.resource_loader.NativeImageInfo;
import com.tencent.biz.expand.api.IResourceLoaderDrawableApi;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.flutter.plugin.QFlutterResourceLoaderNativeImp;

public class ResourceLoaderDrawableApiImpl
  implements IResourceLoaderDrawableApi
{
  public int getDrawableId(String paramString)
  {
    return new QFlutterResourceLoaderNativeImp(BaseApplicationImpl.getContext()).getNativeAppImage(paramString).drawableId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.api.impl.ResourceLoaderDrawableApiImpl
 * JD-Core Version:    0.7.0.1
 */