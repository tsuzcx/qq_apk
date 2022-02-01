package com.tencent.av.video.effect.filter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageBlackNoiseFilter;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageColorAmaroFilter;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageColorEffectFilter;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageColorEffectNewFilter;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageComicFilter;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageGrayscaleFilter;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageShifterEffectFilter;
import com.tencent.av.video.effect.core.qqavimage.SpecialFilter.QQAVImageSingleCurvePicFilter;
import com.tencent.av.video.effect.core.qqavimage.SpecialFilter.QQAVImageTwoCurvePicFilter;
import com.tencent.av.video.effect.core.qqavimage.SpecialFilter.QQAVImageTwoSrcFilter;
import com.tencent.av.video.effect.utils.CommonUtils;
import com.tencent.av.video.effect.utils.Log;
import java.io.File;
import java.lang.ref.WeakReference;
import org.json.JSONArray;
import org.json.JSONObject;

public class FilterFactory
{
  private static final String CONFIG_FILE = "params.json";
  private static final String PARAM_FILTER_ID = "filterId";
  private static final String PARAM_NAME = "name";
  private static final String PARAM_RESOURCE_LIST = "resourceList";
  private static final String PARAM_SUB_ID = "subId";
  private static final String TAG = "FilterFactory";
  private WeakReference<Context> mContextReference;
  private QQAVImageFilter mFilter;
  private String mFilterPath;
  
  public FilterFactory(Context paramContext)
  {
    this.mContextReference = new WeakReference(paramContext);
  }
  
  public static QQAVImageFilter createFilter(Context paramContext, JSONObject paramJSONObject, String paramString)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = null;
    if (paramJSONObject == null) {
      return localObject1;
    }
    localObject1 = localObject3;
    for (;;)
    {
      try
      {
        if (!paramJSONObject.has("filterId")) {
          break label375;
        }
        localObject1 = localObject3;
        i = Integer.valueOf(paramJSONObject.getString("filterId")).intValue();
        localObject1 = localObject3;
        if (!paramJSONObject.has("name")) {
          break label368;
        }
        localObject1 = localObject3;
        str = paramJSONObject.getString("name");
        localObject1 = localObject3;
        if (!paramJSONObject.has("subId")) {
          break label362;
        }
        localObject1 = localObject3;
        j = Integer.valueOf(paramJSONObject.getString("subId")).intValue();
        localObject1 = localObject3;
        if (!paramJSONObject.has("resourceList")) {
          break label356;
        }
        localObject1 = localObject3;
        localJSONArray = paramJSONObject.getJSONArray("resourceList");
      }
      catch (Exception paramContext)
      {
        Log.e("FilterFactory", "createFilter:" + paramContext);
        return localObject1;
      }
      localObject1 = paramJSONObject;
      if (paramJSONObject == null) {
        break;
      }
      localObject1 = paramJSONObject;
      paramJSONObject.setQQAVEffectType(i);
      localObject1 = paramJSONObject;
      paramJSONObject.setQQAVEffectID(str);
      localObject1 = paramJSONObject;
      paramJSONObject.setQQAVEffectName(str);
      localObject1 = paramJSONObject;
      prepareResource(paramContext, paramJSONObject, paramString, localJSONArray);
      return paramJSONObject;
      localObject1 = localObject3;
      paramJSONObject = new QQAVImageComicFilter();
      continue;
      localObject1 = localObject3;
      paramJSONObject = new QQAVImageColorAmaroFilter();
      continue;
      localObject1 = localObject3;
      paramJSONObject = new QQAVImageColorEffectFilter();
      continue;
      localObject1 = localObject3;
      paramJSONObject = new QQAVImageGrayscaleFilter();
      continue;
      localObject1 = localObject3;
      paramJSONObject = new QQAVImageTwoCurvePicFilter(j);
      continue;
      localObject1 = localObject3;
      paramJSONObject = new QQAVImageSingleCurvePicFilter();
      continue;
      localObject1 = localObject3;
      paramJSONObject = new QQAVImageColorEffectNewFilter();
      continue;
      localObject1 = localObject3;
      paramJSONObject = new QQAVImageShifterEffectFilter();
      continue;
      localObject1 = localObject3;
      paramJSONObject = new QQAVImageBlackNoiseFilter();
      continue;
      localObject1 = localObject3;
      paramJSONObject = new QQAVImageTwoSrcFilter();
      continue;
      label356:
      JSONArray localJSONArray = null;
      break label380;
      label362:
      int j = -1;
      continue;
      label368:
      String str = "none";
      continue;
      label375:
      int i = -1;
      continue;
      label380:
      paramJSONObject = localObject2;
      switch (i)
      {
      }
      paramJSONObject = localObject2;
    }
  }
  
  private void destroyFilter()
  {
    if (this.mFilter != null) {
      this.mFilter.destroy();
    }
    this.mFilter = null;
    this.mFilterPath = null;
  }
  
  public static void prepareResource(Context paramContext, QQAVImageFilter paramQQAVImageFilter, String paramString, JSONArray paramJSONArray)
  {
    if ((paramQQAVImageFilter == null) || (paramJSONArray == null) || (paramJSONArray.length() == 0) || (paramContext == null)) {}
    for (;;)
    {
      return;
      int i = 0;
      try
      {
        while (i < paramJSONArray.length())
        {
          Bitmap localBitmap = BitmapFactory.decodeStream(CommonUtils.getInputStreamFromPath(paramContext, paramString + File.separator + paramJSONArray.get(i).toString()));
          if (localBitmap != null) {
            paramQQAVImageFilter.setBitmap(i, localBitmap);
          }
          i += 1;
        }
        return;
      }
      catch (Throwable paramContext)
      {
        Log.e("FilterFactory", "prepareResource:" + paramContext);
      }
    }
  }
  
  public QQAVImageFilter getFilter(String paramString)
  {
    localObject = null;
    if (TextUtils.isEmpty(paramString))
    {
      destroyFilter();
      return null;
    }
    if ((this.mFilterPath != null) && (this.mFilterPath.equals(paramString)) && (this.mFilter != null)) {
      return this.mFilter;
    }
    destroyFilter();
    this.mFilterPath = paramString;
    if ((this.mContextReference != null) && (this.mContextReference.get() != null)) {}
    try
    {
      paramString = CommonUtils.getInputStreamFromPath((Context)this.mContextReference.get(), this.mFilterPath + File.separator + "params.json");
      if (paramString == null) {
        break label192;
      }
      paramString = CommonUtils.convertStreamToString(paramString);
      if (paramString == null) {
        break label192;
      }
      paramString = new JSONObject(paramString);
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e("FilterFactory", "parseJson:" + paramString);
        paramString = localObject;
        continue;
        paramString = null;
      }
    }
    this.mFilter = createFilter((Context)this.mContextReference.get(), paramString, this.mFilterPath);
    return this.mFilter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.video.effect.filter.FilterFactory
 * JD-Core Version:    0.7.0.1
 */