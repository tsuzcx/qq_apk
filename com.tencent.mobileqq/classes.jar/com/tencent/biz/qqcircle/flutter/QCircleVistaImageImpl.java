package com.tencent.biz.qqcircle.flutter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.net.Uri;
import android.text.TextUtils;
import com.qflutter.vistaimage.IRenderer;
import com.qflutter.vistaimage.IVistaImage;
import com.qflutter.vistaimage.IVistaImage.LoadBitmapCallback;
import com.tencent.biz.qcircleshadow.lib.variation.HostAppSettingUtil;
import com.tencent.biz.qqcircle.flutter.animation.FrameAnimationRenderer;
import com.tencent.biz.qqcircle.flutter.animation.PushCountImageRenderer;
import com.tencent.biz.qqcircle.flutter.animation.QCircleFlutterAnimationLoader;
import com.tencent.biz.qqcircle.flutter.animation.QCircleFlutterAnimationLoader.AnimationParam;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class QCircleVistaImageImpl
  implements IVistaImage
{
  public static final String TAG = "QCircleVistaImageImpl";
  private static Map<String, Integer> drawableIdMap = new ConcurrentHashMap();
  private Map<String, Bitmap> cache = new ConcurrentHashMap();
  
  static
  {
    drawableIdMap.put("bg_btn_round_normal", Integer.valueOf(2130845305));
    drawableIdMap.put("bg_btn_round_pressed", Integer.valueOf(2130845306));
    Map localMap = drawableIdMap;
    Integer localInteger = Integer.valueOf(2130845067);
    localMap.put("detailpagemedia_btn_bg", localInteger);
    drawableIdMap.put("detailpagemedia_btn_bg.png", localInteger);
    drawableIdMap.put("icon_interact_comment", Integer.valueOf(2130845386));
    drawableIdMap.put("icon_interact_like_normal", Integer.valueOf(2130845390));
    drawableIdMap.put("icon_interact_like_ghost_normal", Integer.valueOf(2130845388));
    drawableIdMap.put("icon_interact_like_lightgrey_normal", Integer.valueOf(2130845389));
    localMap = drawableIdMap;
    localInteger = Integer.valueOf(2130845393);
    localMap.put("icon_interact_push_normal", localInteger);
    drawableIdMap.put("icon_interact_push_normal.png", localInteger);
    drawableIdMap.put("icon_interact_like_selected", Integer.valueOf(2130845391));
    localMap = drawableIdMap;
    localInteger = Integer.valueOf(2130845394);
    localMap.put("icon_interact_push_selected", localInteger);
    drawableIdMap.put("icon_interact_push_selected.png", localInteger);
    drawableIdMap.put("icon_interact_comment_ghost_normal", Integer.valueOf(2130845387));
    localMap = drawableIdMap;
    localInteger = Integer.valueOf(2130845392);
    localMap.put("icon_interact_push_ghost_normal", localInteger);
    drawableIdMap.put("icon_interact_push_ghost_normal.png", localInteger);
    drawableIdMap.put("icon_general_close_ghost", Integer.valueOf(2130845352));
    drawableIdMap.put("icon_general_more_ghost", Integer.valueOf(2130845373));
    drawableIdMap.put("btn_mini_normal", Integer.valueOf(2130845313));
    drawableIdMap.put("detailpagemedia_btn_mini_normal", Integer.valueOf(2130845326));
    drawableIdMap.put("icon_general_location_ghost", Integer.valueOf(2130845368));
    localMap = drawableIdMap;
    localInteger = Integer.valueOf(2130845090);
    localMap.put("feed_push_explode_pressed", localInteger);
    drawableIdMap.put("feed_push_explode_pressed.png", localInteger);
    drawableIdMap.put("icon_general_filter_ghost", Integer.valueOf(2130845137));
    drawableIdMap.put("icon_general_hot_primary", Integer.valueOf(2130845364));
    drawableIdMap.put("icon_general_planet_primary", Integer.valueOf(2130845378));
    drawableIdMap.put("icon_general_close_secondary", Integer.valueOf(2130845356));
    drawableIdMap.put("icon_general_search_primary", Integer.valueOf(2130845383));
    drawableIdMap.put("icon_general_delete_primary", Integer.valueOf(2130845357));
    localMap = drawableIdMap;
    localInteger = Integer.valueOf(2130845396);
    localMap.put("icon_interact_share_ghost", localInteger);
    drawableIdMap.put("icon_general_share_ghost", localInteger);
    drawableIdMap.put("icon_nav_back", Integer.valueOf(2130845398));
    drawableIdMap.put("icon_general_arrow_right_secondary", Integer.valueOf(2130845351));
    drawableIdMap.put("detailpagemadia_guideline_gesture", Integer.valueOf(2130845325));
    drawableIdMap.put("btn_small_primary_normal", Integer.valueOf(2130845321));
    drawableIdMap.put("feed_tips_share_icon", Integer.valueOf(2130845094));
  }
  
  private Drawable bitmapTransferDrawable(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return new BitmapDrawable(HostUIHelper.getInstance().getHostApplicationContext().getResources());
    }
    byte[] arrayOfByte = paramBitmap.getNinePatchChunk();
    if (NinePatch.isNinePatchChunk(arrayOfByte)) {
      return new NinePatchDrawable(HostUIHelper.getInstance().getHostApplicationContext().getResources(), paramBitmap, arrayOfByte, new Rect(), null);
    }
    return new BitmapDrawable(HostUIHelper.getInstance().getHostApplicationContext().getResources(), paramBitmap);
  }
  
  private void onLoadAnimation(String paramString, int paramInt1, int paramInt2, IVistaImage.LoadBitmapCallback paramLoadBitmapCallback)
  {
    Object localObject1 = Uri.parse(paramString);
    Object localObject2 = ((Uri)localObject1).getQueryParameter("name");
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("[onLoadAnimation] name=");
      ((StringBuilder)localObject3).append((String)localObject2);
      ((StringBuilder)localObject3).append(", uriString=");
      ((StringBuilder)localObject3).append(paramString);
      QLog.d("QCircleVistaImageImpl", 1, ((StringBuilder)localObject3).toString());
    }
    Object localObject3 = QCircleFlutterAnimationLoader.a().a((String)localObject2);
    if ((localObject3 != null) && (((QCircleFlutterAnimationLoader.AnimationParam)localObject3).a != null) && (((QCircleFlutterAnimationLoader.AnimationParam)localObject3).a.length != 0))
    {
      ArrayList localArrayList = new ArrayList();
      String[] arrayOfString = ((QCircleFlutterAnimationLoader.AnimationParam)localObject3).a;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if (str.endsWith(".png")) {
          localArrayList.add(str);
        }
        i += 1;
      }
      ((QCircleFlutterAnimationLoader.AnimationParam)localObject3).a = ((String[])localArrayList.toArray(new String[0]));
      if ("pushCount".equals(localObject2)) {
        try
        {
          localObject1 = new PushCountImageRenderer(Integer.parseInt(((Uri)localObject1).getQueryParameter("push_count")));
          localObject2 = ((PushCountImageRenderer)localObject1).b();
          if (localObject2 == null)
          {
            QLog.w("QCircleVistaImageImpl", 1, "[onLoadAnimation] invalid first bitmap");
            return;
          }
          paramLoadBitmapCallback.onLoaded(paramString, bitmapTransferDrawable((Bitmap)localObject2), false, (IRenderer)localObject1);
          return;
        }
        catch (Exception paramString)
        {
          QLog.e("QCircleVistaImageImpl", 1, "[onLoadAnimation] ", paramString);
          return;
        }
      }
      localObject1 = new FrameAnimationRenderer((String)localObject2, (QCircleFlutterAnimationLoader.AnimationParam)localObject3, paramInt1, paramInt2);
      paramLoadBitmapCallback.onLoaded(paramString, bitmapTransferDrawable(((FrameAnimationRenderer)localObject1).a()), false, (IRenderer)localObject1);
      return;
    }
    QLog.w("QCircleVistaImageImpl", 1, "[onLoadAnimation] invalid animation param");
  }
  
  private void onLoadDrawable(String paramString, int paramInt1, int paramInt2, IVistaImage.LoadBitmapCallback paramLoadBitmapCallback)
  {
    Object localObject1 = (Integer)drawableIdMap.get(paramString);
    if ((localObject1 == null) && (!HostAppSettingUtil.isPublicVersion()))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[onLoadDrawable] no name map:");
      ((StringBuilder)localObject1).append(paramString);
      QLog.w("QCircleVistaImageImpl", 1, ((StringBuilder)localObject1).toString());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("no id map:");
      ((StringBuilder)localObject1).append(paramString);
      paramLoadBitmapCallback.onFailed(paramString, -1, ((StringBuilder)localObject1).toString());
      return;
    }
    if (localObject1 == null)
    {
      localObject1 = QCircleSkinHelper.getInstance();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("qcircle_skin_");
      ((StringBuilder)localObject2).append(paramString);
      localObject2 = ((QCircleSkinHelper)localObject1).getDrawable(((StringBuilder)localObject2).toString());
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = QCircleSkinHelper.getInstance();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("qcircle_");
        ((StringBuilder)localObject2).append(paramString);
        localObject1 = ((QCircleSkinHelper)localObject1).getDrawable(((StringBuilder)localObject2).toString());
      }
    }
    else
    {
      localObject1 = QCircleSkinHelper.getInstance().getDrawable(((Integer)localObject1).intValue());
    }
    if (localObject1 != null)
    {
      paramLoadBitmapCallback.onLoaded(paramString, (Drawable)localObject1, false, null);
      return;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[onLoadDrawable] name:");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(" is not BitmapDrawable");
    QLog.w("QCircleVistaImageImpl", 1, ((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("no BitmapDrawable:");
    ((StringBuilder)localObject1).append(paramString);
    paramLoadBitmapCallback.onFailed(paramString, -1, ((StringBuilder)localObject1).toString());
  }
  
  private void onLoadUrl(String paramString, int paramInt1, int paramInt2, int paramInt3, IVistaImage.LoadBitmapCallback paramLoadBitmapCallback)
  {
    Option localOption = new Option().setUrl(paramString).setPredecode(true);
    if ((paramInt1 > 0) && (paramInt2 > 0)) {
      localOption.setRequestWidth(paramInt1).setRequestHeight(paramInt2);
    }
    QCircleFeedPicLoader.g().loadImage(localOption, new QCircleVistaImageImpl.1(this, paramLoadBitmapCallback, paramString));
  }
  
  private String retrieveUrl(String paramString)
  {
    String str = paramString;
    if (!paramString.startsWith("http"))
    {
      if (paramString.startsWith("https")) {
        return paramString;
      }
      str = QCircleSkinHelper.getInstance().getUrl(paramString);
    }
    return str;
  }
  
  public void clear() {}
  
  public void loadBitmap(String paramString, int paramInt1, int paramInt2, int paramInt3, IVistaImage.LoadBitmapCallback paramLoadBitmapCallback)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[loadBitmap] uriString=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("QCircleVistaImageImpl", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = retrieveUrl(paramString);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      onLoadUrl((String)localObject, paramInt1, paramInt2, paramInt3, paramLoadBitmapCallback);
      return;
    }
    if (paramString.startsWith("animation://"))
    {
      onLoadAnimation(paramString, paramInt1, paramInt2, paramLoadBitmapCallback);
      return;
    }
    onLoadDrawable(paramString, paramInt1, paramInt2, paramLoadBitmapCallback);
  }
  
  public void releaseBitmap(String paramString)
  {
    this.cache.remove(paramString);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("[releaseBitmap] cache size=");
      paramString.append(this.cache.size());
      QLog.d("QCircleVistaImageImpl", 2, paramString.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.flutter.QCircleVistaImageImpl
 * JD-Core Version:    0.7.0.1
 */