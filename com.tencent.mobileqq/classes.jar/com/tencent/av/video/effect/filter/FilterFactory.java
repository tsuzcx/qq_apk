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
import java.io.InputStream;
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
    Object localObject3 = null;
    Object localObject2 = null;
    if (paramJSONObject == null) {
      return null;
    }
    Object localObject1 = localObject3;
    int i;
    JSONArray localJSONArray;
    try
    {
      boolean bool = paramJSONObject.has("filterId");
      j = -1;
      if (!bool) {
        break label372;
      }
      localObject1 = localObject3;
      i = Integer.valueOf(paramJSONObject.getString("filterId")).intValue();
      str = "none";
      localObject1 = localObject3;
      if (paramJSONObject.has("name"))
      {
        localObject1 = localObject3;
        str = paramJSONObject.getString("name");
      }
      localObject1 = localObject3;
      if (paramJSONObject.has("subId"))
      {
        localObject1 = localObject3;
        j = Integer.valueOf(paramJSONObject.getString("subId")).intValue();
      }
      localObject1 = localObject3;
      if (!paramJSONObject.has("resourceList")) {
        break label377;
      }
      localObject1 = localObject3;
      localJSONArray = paramJSONObject.getJSONArray("resourceList");
    }
    catch (Exception paramContext)
    {
      int j;
      String str;
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("createFilter:");
      paramJSONObject.append(paramContext);
      Log.e("FilterFactory", paramJSONObject.toString());
    }
    localObject1 = localObject3;
    paramJSONObject = new QQAVImageTwoSrcFilter();
    break label458;
    localObject1 = localObject3;
    paramJSONObject = new QQAVImageBlackNoiseFilter();
    break label458;
    localObject1 = localObject3;
    paramJSONObject = new QQAVImageShifterEffectFilter();
    break label458;
    localObject1 = localObject3;
    paramJSONObject = new QQAVImageColorEffectNewFilter();
    break label458;
    localObject1 = localObject3;
    paramJSONObject = new QQAVImageSingleCurvePicFilter();
    break label458;
    localObject1 = localObject3;
    paramJSONObject = new QQAVImageTwoCurvePicFilter(j);
    break label458;
    localObject1 = localObject3;
    paramJSONObject = new QQAVImageGrayscaleFilter();
    break label458;
    localObject1 = localObject3;
    paramJSONObject = new QQAVImageComicFilter();
    break label458;
    localObject1 = localObject3;
    paramJSONObject = new QQAVImageColorAmaroFilter();
    break label458;
    localObject1 = localObject3;
    paramJSONObject = new QQAVImageColorEffectFilter();
    label458:
    for (;;)
    {
      localObject1 = paramJSONObject;
      if (paramJSONObject != null)
      {
        localObject1 = paramJSONObject;
        paramJSONObject.setQQAVEffectType(i);
        localObject1 = paramJSONObject;
        paramJSONObject.setQQAVEffectID(str);
        localObject1 = paramJSONObject;
        paramJSONObject.setQQAVEffectName(str);
        localObject1 = paramJSONObject;
        prepareResource(paramContext, paramJSONObject, paramString, localJSONArray);
        return paramJSONObject;
      }
      return localObject1;
      label372:
      i = -1;
      break;
      label377:
      localJSONArray = null;
      switch (i)
      {
      }
      paramJSONObject = localObject2;
    }
  }
  
  private void destroyFilter()
  {
    QQAVImageFilter localQQAVImageFilter = this.mFilter;
    if (localQQAVImageFilter != null) {
      localQQAVImageFilter.destroy();
    }
    this.mFilter = null;
    this.mFilterPath = null;
  }
  
  public static void prepareResource(Context paramContext, QQAVImageFilter paramQQAVImageFilter, String paramString, JSONArray paramJSONArray)
  {
    if ((paramQQAVImageFilter != null) && (paramJSONArray != null) && (paramJSONArray.length() != 0))
    {
      if (paramContext == null) {
        return;
      }
      int i = 0;
      try
      {
        while (i < paramJSONArray.length())
        {
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append(File.separator);
          ((StringBuilder)localObject).append(paramJSONArray.get(i).toString());
          localObject = BitmapFactory.decodeStream(CommonUtils.getInputStreamFromPath(paramContext, ((StringBuilder)localObject).toString()));
          if (localObject != null) {
            paramQQAVImageFilter.setBitmap(i, (Bitmap)localObject);
          }
          i += 1;
        }
        return;
      }
      catch (Throwable paramContext)
      {
        paramQQAVImageFilter = new StringBuilder();
        paramQQAVImageFilter.append("prepareResource:");
        paramQQAVImageFilter.append(paramContext);
        Log.e("FilterFactory", paramQQAVImageFilter.toString());
      }
    }
  }
  
  public QQAVImageFilter getFilter(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject1 = null;
    if (bool)
    {
      destroyFilter();
      return null;
    }
    Object localObject2 = this.mFilterPath;
    if ((localObject2 != null) && (((String)localObject2).equals(paramString)))
    {
      localObject2 = this.mFilter;
      if (localObject2 != null) {
        return localObject2;
      }
    }
    destroyFilter();
    this.mFilterPath = paramString;
    paramString = this.mContextReference;
    if ((paramString != null) && (paramString.get() != null))
    {
      try
      {
        paramString = (Context)this.mContextReference.get();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.mFilterPath);
        ((StringBuilder)localObject2).append(File.separator);
        ((StringBuilder)localObject2).append("params.json");
        localObject2 = CommonUtils.getInputStreamFromPath(paramString, ((StringBuilder)localObject2).toString());
        paramString = localObject1;
        if (localObject2 != null)
        {
          localObject2 = CommonUtils.convertStreamToString((InputStream)localObject2);
          paramString = localObject1;
          if (localObject2 != null) {
            paramString = new JSONObject((String)localObject2);
          }
        }
      }
      catch (Exception paramString)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("parseJson:");
        ((StringBuilder)localObject2).append(paramString);
        Log.e("FilterFactory", ((StringBuilder)localObject2).toString());
        paramString = localObject1;
      }
      this.mFilter = createFilter((Context)this.mContextReference.get(), paramString, this.mFilterPath);
    }
    return this.mFilter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.video.effect.filter.FilterFactory
 * JD-Core Version:    0.7.0.1
 */