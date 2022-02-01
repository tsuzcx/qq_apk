package com.tencent.aelight.camera.aioeditor.doodle.ui.face;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.capture.util.InfoStickerSaveUtils;
import com.tencent.aelight.camera.aioeditor.capture.util.InfoStickerUtils;
import com.tencent.aelight.camera.aioeditor.doodle.ui.widget.CalendarTimeStickerDrawable;
import com.tencent.aelight.camera.aioeditor.doodle.ui.widget.CityStickerDrawable;
import com.tencent.aelight.camera.aioeditor.doodle.ui.widget.EaseInInfoStickerDrawable;
import com.tencent.aelight.camera.aioeditor.doodle.ui.widget.EaseInLocationStickerDrawable;
import com.tencent.aelight.camera.aioeditor.doodle.ui.widget.ExpandLocationStickerDrawable;
import com.tencent.aelight.camera.aioeditor.doodle.ui.widget.FilmDigitInfoStickerDrawable;
import com.tencent.aelight.camera.aioeditor.doodle.ui.widget.InfoStickerDrawable;
import com.tencent.aelight.camera.aioeditor.doodle.ui.widget.Left2RightInfoStickerDrawable;
import com.tencent.aelight.camera.aioeditor.doodle.ui.widget.LunaInfoStickerDrawable;
import com.tencent.aelight.camera.aioeditor.doodle.ui.widget.RandomTextDrawable;
import com.tencent.aelight.camera.aioeditor.doodle.ui.widget.TriangleLocationStickerDrawble;
import com.tencent.aelight.camera.aioeditor.doodle.ui.widget.WeatherStickerDrawable;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class InformationFaceConstant
{
  private static final Set<Integer> a = new HashSet(5);
  private static final Set<Integer> b = new HashSet(5);
  
  static
  {
    a.add(Integer.valueOf(4));
    a.add(Integer.valueOf(5));
    Set localSet = a;
    Integer localInteger1 = Integer.valueOf(9);
    localSet.add(localInteger1);
    localSet = a;
    Integer localInteger2 = Integer.valueOf(10);
    localSet.add(localInteger2);
    b.add(localInteger1);
    b.add(localInteger2);
  }
  
  private InformationFaceConstant()
  {
    throw new UnsupportedOperationException("Can not create an instance.");
  }
  
  public static int a(InformationFacePackage.Item paramItem)
  {
    int j = paramItem.a;
    int i = 1;
    switch (j)
    {
    case 1: 
    case 2: 
    default: 
      i = 0;
      break;
    case 12: 
      i = 5;
      break;
    case 11: 
      i = 3;
      break;
    case 8: 
      i = 14;
      break;
    case 6: 
      i = 33;
      break;
    case 5: 
    case 9: 
    case 10: 
      i = 2;
      break;
    case 3: 
      i = 4;
    }
    if (QLog.isColorLevel())
    {
      paramItem = new StringBuilder();
      paramItem.append("check num of download dir:");
      paramItem.append(i);
      QLog.d("InformationFaceConstant", 2, paramItem.toString());
    }
    return i;
  }
  
  public static BitmapDrawable a(String paramString1, Context paramContext, String paramString2)
  {
    Object localObject3 = null;
    Object localObject2;
    try
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("to be parsed");
        ((StringBuilder)localObject1).append(paramString1);
        QLog.e("InformationFaceConstant", 2, ((StringBuilder)localObject1).toString());
      }
      Object localObject1 = new JSONObject(paramString1);
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("InformationFaceConstant", 2, localJSONException, new Object[0]);
      }
      localObject2 = null;
    }
    if (localObject2 == null) {
      return null;
    }
    int i = localObject2.optInt("type", 0);
    if (i != 4)
    {
      if (i != 5)
      {
        if (i != 9)
        {
          if (i != 10)
          {
            if (i != 12) {
              paramString1 = null;
            } else {
              paramString1 = new FilmDigitInfoStickerDrawable(paramContext, FilmDigitInfoStickerDrawable.a(i, new FilmDigitInfoStickerDrawable(paramContext, paramString1).a(paramString1)[1]));
            }
          }
          else
          {
            paramString1 = new TriangleLocationStickerDrawble(paramContext, paramString1).a(paramString1);
            paramString1 = new TriangleLocationStickerDrawble(paramContext, TriangleLocationStickerDrawble.a(i, paramString1[0], paramString1[1], paramString2));
          }
        }
        else {
          paramString1 = new ExpandLocationStickerDrawable(paramContext, ExpandLocationStickerDrawable.a(i, new ExpandLocationStickerDrawable(paramContext, paramString1).a(paramString1)[0], paramString2));
        }
      }
      else
      {
        paramString1 = new EaseInLocationStickerDrawable(paramContext, paramString1).a(paramString1);
        paramString1 = new EaseInLocationStickerDrawable(paramContext, EaseInLocationStickerDrawable.a(i, paramString2, paramString1[1], paramString1[3], paramString1[2]));
      }
    }
    else
    {
      paramString1 = new Left2RightInfoStickerDrawable(paramContext, paramString1).a(paramString1);
      paramString1 = new Left2RightInfoStickerDrawable(paramContext, Left2RightInfoStickerDrawable.a(i, paramString1[0], paramString2, paramString1[2]));
    }
    paramString2 = localObject3;
    if (paramString1 != null) {
      paramString2 = new BitmapDrawable(paramContext.getResources(), paramString1.a());
    }
    return paramString2;
  }
  
  public static InfoStickerDrawable a(Context paramContext, String paramString)
  {
    Object localObject2;
    try
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("to be parsed");
        ((StringBuilder)localObject1).append(paramString);
        QLog.e("InformationFaceConstant", 2, ((StringBuilder)localObject1).toString());
      }
      Object localObject1 = new JSONObject(paramString);
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("InformationFaceConstant", 2, localJSONException, new Object[0]);
      }
      localObject2 = null;
    }
    if (localObject2 == null) {
      return null;
    }
    switch (localObject2.optInt("type", 0))
    {
    case 8: 
    default: 
      return null;
    case 12: 
      return new FilmDigitInfoStickerDrawable(paramContext, paramString);
    case 11: 
      return new CalendarTimeStickerDrawable(paramContext, paramString);
    case 10: 
      return new TriangleLocationStickerDrawble(paramContext, paramString);
    case 9: 
      return new ExpandLocationStickerDrawable(paramContext, paramString);
    case 7: 
      return new CityStickerDrawable(paramContext, paramString);
    case 6: 
      return new WeatherStickerDrawable(paramContext, paramString);
    case 5: 
      return new EaseInLocationStickerDrawable(paramContext, paramString);
    case 4: 
      return new Left2RightInfoStickerDrawable(paramContext, paramString);
    case 3: 
      return new LunaInfoStickerDrawable(paramContext, paramString);
    case 2: 
      return new RandomTextDrawable(paramContext, paramString);
    }
    return new EaseInInfoStickerDrawable(paramContext, paramString);
  }
  
  public static InfoStickerDrawable a(InformationFacePackage.Item paramItem, Context paramContext, long paramLong)
  {
    int i = paramItem.a;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    switch (i)
    {
    case 8: 
    default: 
      return null;
    case 12: 
      return new FilmDigitInfoStickerDrawable(paramContext, FilmDigitInfoStickerDrawable.a(i, InfoStickerUtils.g(paramLong)));
    case 11: 
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(InfoStickerSaveUtils.b(paramItem));
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append("up.png");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(InfoStickerSaveUtils.b(paramItem));
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append("down.png");
      return new CalendarTimeStickerDrawable(paramContext, CalendarTimeStickerDrawable.a(i, (String)localObject1, ((StringBuilder)localObject2).toString(), InfoStickerUtils.h(paramLong), InfoStickerUtils.i(paramLong)));
    case 10: 
      localObject1 = paramItem.l;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(InfoStickerSaveUtils.b(paramItem));
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append("location4_icon.png");
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(InfoStickerSaveUtils.b(paramItem));
      ((StringBuilder)localObject3).append(File.separator);
      ((StringBuilder)localObject3).append("lantingzhonghei.ttf");
      return new TriangleLocationStickerDrawble(paramContext, TriangleLocationStickerDrawble.a(i, (String)localObject2, ((StringBuilder)localObject3).toString(), (String)localObject1));
    case 9: 
      localObject2 = paramItem.l;
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = "YOUR CITY";
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(InfoStickerSaveUtils.b(paramItem));
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append("location3_icon_3x.png");
      return new ExpandLocationStickerDrawable(paramContext, ExpandLocationStickerDrawable.a(i, ((StringBuilder)localObject2).toString(), (String)localObject1));
    case 7: 
      paramItem = InfoStickerSaveUtils.b(paramItem);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramItem);
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append("city.bpng");
      return new CityStickerDrawable(paramContext, CityStickerDrawable.a(i, ((StringBuilder)localObject1).toString()));
    case 6: 
      localObject1 = InfoStickerSaveUtils.b(paramItem);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append("DINCond-Medium.ttf");
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append(File.separator);
      ((StringBuilder)localObject3).append(paramItem.k);
      ((StringBuilder)localObject3).append(".apng");
      localObject3 = ((StringBuilder)localObject3).toString();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append((String)localObject1);
      ((StringBuilder)localObject4).append(File.separator);
      ((StringBuilder)localObject4).append("temperatureSymbol.png");
      localObject4 = ((StringBuilder)localObject4).toString();
      String str = paramItem.j;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(File.separator);
      localStringBuilder.append("line.png");
      localObject1 = localStringBuilder.toString();
      int j = paramItem.c;
      boolean bool;
      if (paramItem.d == 3) {
        bool = true;
      } else {
        bool = false;
      }
      return new WeatherStickerDrawable(paramContext, WeatherStickerDrawable.a(i, j, (String)localObject3, str, (String)localObject4, (String)localObject2, (String)localObject1, bool));
    case 5: 
      localObject1 = InfoStickerSaveUtils.b(paramItem);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append("Roboto-Condensed.ttf");
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append(File.separator);
      ((StringBuilder)localObject3).append("location_icon.png");
      localObject3 = ((StringBuilder)localObject3).toString();
      localObject1 = paramItem.l;
      if (TextUtils.isEmpty(paramItem.l)) {
        localObject1 = HardCodeUtil.a(2064515392);
      }
      return new EaseInLocationStickerDrawable(paramContext, EaseInLocationStickerDrawable.a(i, (String)localObject1, InfoStickerUtils.f(paramLong), (String)localObject3, (String)localObject2));
    case 4: 
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(InfoStickerSaveUtils.b(paramItem));
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append("Roboto-Condensed.ttf");
      localObject2 = ((StringBuilder)localObject1).toString();
      localObject1 = paramItem.l;
      if (TextUtils.isEmpty(paramItem.l)) {
        localObject1 = HardCodeUtil.a(2064515393);
      }
      return new Left2RightInfoStickerDrawable(paramContext, Left2RightInfoStickerDrawable.a(i, InfoStickerUtils.b(paramLong), (String)localObject1, (String)localObject2));
    case 3: 
      localObject2 = InfoStickerSaveUtils.b(paramItem);
      paramItem = InfoStickerUtils.a(paramLong);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append("eea02a45.ttf");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject2);
      ((StringBuilder)localObject3).append(File.separator);
      ((StringBuilder)localObject3).append("outsideBorder.png");
      localObject3 = ((StringBuilder)localObject3).toString();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append((String)localObject2);
      ((StringBuilder)localObject4).append(File.separator);
      ((StringBuilder)localObject4).append("insideBorder.png");
      localObject2 = ((StringBuilder)localObject4).toString();
      if (QLog.isColorLevel())
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("luar.ttf file name:");
        ((StringBuilder)localObject4).append((String)localObject1);
        QLog.d("InformationFaceConstant", 2, ((StringBuilder)localObject4).toString());
      }
      return new LunaInfoStickerDrawable(paramContext, LunaInfoStickerDrawable.a(i, paramItem[2], paramItem[3], paramItem[0], paramItem[1], (String)localObject1, (String)localObject3, (String)localObject2));
    case 2: 
      return new RandomTextDrawable(paramContext, RandomTextDrawable.a(i, InfoStickerUtils.b(paramLong), InfoStickerUtils.a(paramLong)));
    }
    return new EaseInInfoStickerDrawable(paramContext, EaseInInfoStickerDrawable.a(i, InfoStickerUtils.c(paramLong), InfoStickerUtils.d(paramLong), InfoStickerUtils.e(paramLong)));
  }
  
  public static InfoStickerDrawable a(InfoStickerDrawable paramInfoStickerDrawable, Context paramContext, String paramString)
  {
    switch (paramInfoStickerDrawable.a())
    {
    case 6: 
    case 7: 
    case 8: 
    default: 
      break;
    case 12: 
      paramInfoStickerDrawable = (FilmDigitInfoStickerDrawable)paramInfoStickerDrawable;
      return new FilmDigitInfoStickerDrawable(paramContext, FilmDigitInfoStickerDrawable.a(paramInfoStickerDrawable.a(), paramInfoStickerDrawable.a()));
    case 11: 
      paramInfoStickerDrawable = (CalendarTimeStickerDrawable)paramInfoStickerDrawable;
      return new CalendarTimeStickerDrawable(paramContext, CalendarTimeStickerDrawable.a(paramInfoStickerDrawable.a(), paramInfoStickerDrawable.a(), paramInfoStickerDrawable.b(), InfoStickerUtils.h(-1L), InfoStickerUtils.i(-1L)));
    case 10: 
      paramInfoStickerDrawable = (TriangleLocationStickerDrawble)paramInfoStickerDrawable;
      return new TriangleLocationStickerDrawble(paramContext, TriangleLocationStickerDrawble.a(paramInfoStickerDrawable.a(), paramInfoStickerDrawable.a(), paramInfoStickerDrawable.b(), paramString));
    case 9: 
      paramInfoStickerDrawable = (ExpandLocationStickerDrawable)paramInfoStickerDrawable;
      return new ExpandLocationStickerDrawable(paramContext, ExpandLocationStickerDrawable.a(paramInfoStickerDrawable.a(), paramInfoStickerDrawable.a(), paramString));
    case 5: 
      paramInfoStickerDrawable = (EaseInLocationStickerDrawable)paramInfoStickerDrawable;
      return new EaseInLocationStickerDrawable(paramContext, EaseInLocationStickerDrawable.a(paramInfoStickerDrawable.a(), paramString, InfoStickerUtils.f(-1L), paramInfoStickerDrawable.a(), paramInfoStickerDrawable.b()));
    case 4: 
      paramInfoStickerDrawable = (Left2RightInfoStickerDrawable)paramInfoStickerDrawable;
      return new Left2RightInfoStickerDrawable(paramContext, Left2RightInfoStickerDrawable.a(paramInfoStickerDrawable.a(), paramInfoStickerDrawable.a(), paramString, paramInfoStickerDrawable.b()));
    case 2: 
      return new RandomTextDrawable(paramContext, RandomTextDrawable.a(paramInfoStickerDrawable.a(), InfoStickerUtils.b(-1L), InfoStickerUtils.a(-1L)));
    case 1: 
      return new EaseInInfoStickerDrawable(paramContext, EaseInInfoStickerDrawable.a(paramInfoStickerDrawable.a(), InfoStickerUtils.c(-1L), InfoStickerUtils.d(-1L), InfoStickerUtils.e(-1L)));
    }
    return null;
  }
  
  public static boolean a(int paramInt)
  {
    return a.contains(Integer.valueOf(paramInt));
  }
  
  public static boolean b(int paramInt)
  {
    return b.contains(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.doodle.ui.face.InformationFaceConstant
 * JD-Core Version:    0.7.0.1
 */