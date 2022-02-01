import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.surfaceviewaction.builder.SceneBuilder.1;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite;
import com.tencent.mobileqq.surfaceviewaction.nv.SpriteNativeView;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.JSONArray;
import org.json.JSONObject;

public class bdyn
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private bdyr jdField_a_of_type_Bdyr;
  private bdys jdField_a_of_type_Bdys;
  private bdyt jdField_a_of_type_Bdyt;
  private bdyu jdField_a_of_type_Bdyu;
  private bdyv jdField_a_of_type_Bdyv;
  private bdyy jdField_a_of_type_Bdyy;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  
  private bdxv a(bdyb parambdyb, JSONObject paramJSONObject)
  {
    int n;
    Object localObject1;
    Object localObject3;
    label38:
    Object localObject2;
    int i1;
    int i;
    Paint localPaint;
    Object localObject5;
    int k;
    Object localObject4;
    int i4;
    if ((parambdyb instanceof SpriteGLView))
    {
      n = 4;
      localObject1 = paramJSONObject.optString("text");
      if (!(parambdyb instanceof SpriteGLView)) {
        break label764;
      }
      localObject3 = new bdzh((SpriteGLView)parambdyb);
      ((bdxv)localObject3).c(1.0F / n);
      localObject2 = localObject1;
      if (this.jdField_a_of_type_Bdyu != null) {
        localObject2 = this.jdField_a_of_type_Bdyu.a((bdya)localObject3, (String)localObject1);
      }
      i1 = paramJSONObject.optInt("textSize", 20) * n;
      i = Color.parseColor(paramJSONObject.optString("textColor"));
      localPaint = new Paint();
      localPaint.setAntiAlias(true);
      localPaint.setColor(i);
      localPaint.setTextSize(i1);
      localObject5 = paramJSONObject.optJSONObject("size");
      k = (int)localPaint.measureText((String)localObject2);
      localObject4 = paramJSONObject.optString("imageRight");
      i4 = paramJSONObject.optInt("imagePadding") * n;
      if (TextUtils.isEmpty((CharSequence)localObject4)) {
        break label961;
      }
      if (this.jdField_a_of_type_Bdyt == null) {
        break label955;
      }
      localObject1 = this.jdField_a_of_type_Bdyt.a((bdya)localObject3, this.jdField_a_of_type_JavaLangString, (String)localObject4);
      label205:
      if (localObject1 != null) {
        break label817;
      }
    }
    label817:
    label946:
    label955:
    label961:
    for (;;)
    {
      int j;
      int m;
      int i2;
      float f2;
      float f1;
      float f6;
      float f3;
      float f5;
      try
      {
        localObject4 = bheg.a(this.jdField_a_of_type_JavaLangString + "/" + (String)localObject4, null);
        localObject1 = localObject4;
        if (localObject1 == null) {
          break label946;
        }
        i = ((Bitmap)localObject1).getWidth();
        j = ((Bitmap)localObject1).getHeight();
        j *= n;
        i *= n;
        if (localObject5 == null) {
          break label935;
        }
        if (((JSONObject)localObject5).optInt("width") == 0) {
          break label932;
        }
        k = ((JSONObject)localObject5).optInt("width") * n;
        if (((JSONObject)localObject5).optInt("height") == 0) {
          break label925;
        }
        m = ((JSONObject)localObject5).optInt("height") * n;
        if (this.jdField_a_of_type_Bdyu != null) {
          this.jdField_a_of_type_Bdyu.a(k - i - i4, (String)localObject2, localPaint);
        }
        localObject2 = a(k - i - i4, (String)localObject2, localPaint);
        i2 = m;
        m = k;
        if (this.jdField_a_of_type_Bdyu == null) {
          break label919;
        }
        k = this.jdField_a_of_type_Bdyu.a(m, i, i4, (String)localObject2, localPaint);
        i3 = k;
        if (k == 0) {
          i3 = (int)localPaint.measureText((String)localObject2);
        }
        i = i + i3 + i4;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        int i3;
        float f7;
        float f4;
        label764:
        if (QLog.isColorLevel()) {
          QLog.e("SceneBuilder", 2, "buildLabel" + QLog.getStackTraceString(localOutOfMemoryError));
        }
      }
      try
      {
        localObject4 = Bitmap.createBitmap(m, i2, Bitmap.Config.ARGB_8888);
        localObject5 = new Canvas((Bitmap)localObject4);
        ((Canvas)localObject5).drawColor(-16777216, PorterDuff.Mode.CLEAR);
        f7 = i1 * 0.8F;
        f2 = 0.0F;
        f1 = 0.0F;
        f4 = 0.0F;
        f6 = 0.0F;
        f3 = 0.0F;
        f5 = 0.0F;
        paramJSONObject = paramJSONObject.optString("gravity");
        if (paramJSONObject == null) {
          break label913;
        }
        if (!paramJSONObject.contains("left")) {
          break label858;
        }
        f1 = 0.0F;
        if (!paramJSONObject.contains("top")) {
          break label877;
        }
        f2 = 0.0F;
        f3 = f5;
        f4 = f2;
        if (paramJSONObject.equals("center"))
        {
          f1 = (m - i) / 2;
          f4 = (i2 - i1) / 2;
          f3 = (i2 - j) / 2;
        }
        if (paramJSONObject.contains("center_horizontal")) {
          f1 = (m - i) / 2;
        }
        f2 = f1;
        if (!paramJSONObject.contains("center_vertical")) {
          break label913;
        }
        f2 = (i2 - i1) / 2;
        f3 = (i2 - j) / 2;
        f4 = f2;
        f2 = f1;
        f1 = f3;
        if ((this.jdField_a_of_type_Bdyu == null) || (!this.jdField_a_of_type_Bdyu.a((Canvas)localObject5, (String)localObject2, f2, f4, f7, m, i2, localPaint))) {
          ((Canvas)localObject5).drawText((String)localObject2, f2, f4 + f7, localPaint);
        }
        if (localObject1 != null)
        {
          paramJSONObject = new Matrix();
          paramJSONObject.postScale(n, n);
          f3 = i4;
          paramJSONObject.postTranslate(i3 + (f3 + f2), f1);
          ((Canvas)localObject5).drawBitmap((Bitmap)localObject1, paramJSONObject, localPaint);
        }
        ((bdya)localObject3).a(parambdyb, (Bitmap)localObject4);
      }
      catch (OutOfMemoryError parambdyb)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("SceneBuilder", 2, "buildLabel" + QLog.getStackTraceString(parambdyb));
        return localObject3;
      }
      return localObject3;
      n = 1;
      break;
      localObject3 = new bdzu((SpriteNativeView)parambdyb);
      break label38;
      continue;
      label858:
      if (paramJSONObject.contains("right"))
      {
        f1 = m - i;
        continue;
        label877:
        f3 = f5;
        f2 = f6;
        if (paramJSONObject.contains("bottom"))
        {
          f2 = i2 - i1;
          f3 = i2 - j;
          continue;
          f1 = f3;
          continue;
          k = 0;
          continue;
          m = i1;
          continue;
          continue;
          i2 = i1;
          m = k;
          continue;
          j = 0;
          i = 0;
          continue;
          localObject1 = null;
          break label205;
          localObject1 = null;
          j = 0;
          i = 0;
        }
      }
    }
  }
  
  private bdxv a(bdyb parambdyb, JSONObject paramJSONObject, bdxz parambdxz)
  {
    Object localObject1 = null;
    Object localObject3 = paramJSONObject.optString("type");
    if ("layer".equals(localObject3)) {
      if ((parambdyb instanceof SpriteGLView)) {
        localObject1 = new bdze((SpriteGLView)parambdyb);
      }
    }
    Object localObject6;
    label134:
    int i;
    int j;
    label412:
    label457:
    Object localObject2;
    while (localObject1 == null)
    {
      localObject3 = null;
      return localObject3;
      localObject1 = new bdzs((SpriteNativeView)parambdyb);
      continue;
      if ("image".equals(localObject3))
      {
        localObject1 = null;
        Object localObject4 = paramJSONObject.optString("path");
        localObject6 = paramJSONObject.optString("event");
        if ((parambdyb instanceof SpriteGLView))
        {
          localObject3 = (SpriteGLView)parambdyb;
          if (TextUtils.isEmpty((CharSequence)localObject6))
          {
            localObject3 = new bdzh((SpriteGLView)localObject3);
            if (this.jdField_a_of_type_Bdyt != null) {
              localObject1 = this.jdField_a_of_type_Bdyt.a((bdya)localObject3, this.jdField_a_of_type_JavaLangString, (String)localObject4);
            }
            if (localObject1 != null) {
              break label412;
            }
          }
        }
        for (;;)
        {
          for (;;)
          {
            try
            {
              localObject4 = bheg.a(this.jdField_a_of_type_JavaLangString + "/" + (String)localObject4, null);
              localObject1 = localObject3;
              if (localObject4 == null) {
                break;
              }
              localObject1 = paramJSONObject.optJSONObject("size");
              if (localObject1 == null) {
                break label457;
              }
              i = ((JSONObject)localObject1).optInt("width");
              j = ((JSONObject)localObject1).optInt("height");
            }
            catch (OutOfMemoryError localOutOfMemoryError2)
            {
              if (QLog.isColorLevel()) {
                QLog.e("SceneBuilder", 2, "buildNode" + QLog.getStackTraceString(localOutOfMemoryError2));
              }
            }
            try
            {
              localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject4, i, j, true);
              ((bdya)localObject3).a(parambdyb, (Bitmap)localObject1);
              localObject1 = localObject3;
            }
            catch (OutOfMemoryError localOutOfMemoryError1)
            {
              if (!QLog.isColorLevel()) {
                break label457;
              }
              QLog.e("SceneBuilder", 2, "buildNode" + QLog.getStackTraceString(localOutOfMemoryError1));
            }
          }
          localObject3 = new bdzb((SpriteGLView)localObject3, true, (String)localObject6);
          ((bdzb)localObject3).a(new bdyo(this, parambdxz, (String)localObject6));
          break label134;
          localObject3 = (SpriteNativeView)parambdyb;
          if (TextUtils.isEmpty((CharSequence)localObject6))
          {
            localObject3 = new bdzu((SpriteNativeView)localObject3);
            break label134;
          }
          localObject3 = new bdzr((SpriteNativeView)localObject3, (String)localObject6);
          ((bdzr)localObject3).a(new bdyp(this, parambdxz, (bdxv)localObject3, (String)localObject6));
          break label134;
          localObject5 = localObject1;
          continue;
          localObject2 = localObject5;
        }
      }
      if ("video".equals(localObject3))
      {
        if ((parambdyb instanceof SpriteGLView))
        {
          localObject3 = (SpriteGLView)parambdyb;
          localObject2 = new VideoSprite((SpriteGLView)localObject3, ((SpriteGLView)localObject3).getContext(), true);
          ((VideoSprite)localObject2).c(this.jdField_a_of_type_JavaLangString + "/" + paramJSONObject.optString("path"));
          if (paramJSONObject.optBoolean("isKey", false)) {
            ((SpriteGLView)localObject3).setVideoTimeGetter((VideoSprite)localObject2);
          }
          if (paramJSONObject.optBoolean("autoClose", false)) {
            ((VideoSprite)localObject2).a(this.jdField_a_of_type_Bdyy);
          }
          ((VideoSprite)localObject2).a(paramJSONObject.optBoolean("isLooping", false));
        }
        else
        {
          localObject2 = (SpriteNativeView)parambdyb;
          localObject3 = this.jdField_a_of_type_JavaLangString + "/" + paramJSONObject.optString("path");
          localObject2 = new bdzv((SpriteNativeView)localObject2, (String)localObject3);
          ((bdzv)localObject2).a((String)localObject3, paramJSONObject.optBoolean("isLooping", false));
        }
      }
      else if ("label".equals(localObject3)) {
        localObject2 = a(parambdyb, paramJSONObject);
      }
    }
    ((bdxv)localObject2).a(paramJSONObject.optString("name"));
    ((bdxv)localObject2).a(paramJSONObject.optInt("tag"));
    ((bdxv)localObject2).a((float)paramJSONObject.optDouble("x", 0.0D));
    ((bdxv)localObject2).b((float)paramJSONObject.optDouble("y", 0.0D));
    ((bdxv)localObject2).b((int)(paramJSONObject.optDouble("alpha", 1.0D) * 255.0D));
    ((bdxv)localObject2).c(((bdxv)localObject2).a() * (float)paramJSONObject.optDouble("scale", 1.0D));
    ((bdxv)localObject2).d((float)paramJSONObject.optDouble("rotate", 0.0D));
    ((bdxv)localObject2).e(((bdxv)parambdxz).a());
    localObject3 = paramJSONObject.optJSONArray("actions");
    if (localObject3 != null) {
      ((bdxv)localObject2).a(a((JSONArray)localObject3));
    }
    Object localObject5 = paramJSONObject.optJSONObject("frames");
    if (localObject5 != null)
    {
      localObject3 = new bdxw();
      ((bdxw)localObject3).jdField_a_of_type_Int = ((JSONObject)localObject5).optInt("fps");
      localObject5 = ((JSONObject)localObject5).optJSONArray("datas");
      j = ((JSONArray)localObject5).length();
      ((bdxw)localObject3).jdField_a_of_type_ArrayOfBdxx = new bdxx[j];
      i = 0;
      while (i < j)
      {
        ((bdxw)localObject3).jdField_a_of_type_ArrayOfBdxx[i] = new bdxx();
        localObject6 = ((JSONArray)localObject5).optJSONObject(i);
        localObject3.jdField_a_of_type_ArrayOfBdxx[i].jdField_a_of_type_Float = ((JSONObject)localObject6).optInt("x");
        localObject3.jdField_a_of_type_ArrayOfBdxx[i].b = ((JSONObject)localObject6).optInt("y");
        i += 1;
      }
      ((bdxv)localObject2).a((bdxw)localObject3);
    }
    localObject3 = paramJSONObject.optString("horizontal_align");
    if (localObject3 != null)
    {
      if (((String)localObject3).equals("left")) {
        ((bdxv)localObject2).c(0);
      }
    }
    else
    {
      label1028:
      localObject3 = paramJSONObject.optString("vertical_align");
      if (localObject3 != null)
      {
        if (!((String)localObject3).equals("top")) {
          break label1180;
        }
        ((bdxv)localObject2).d(0);
      }
    }
    for (;;)
    {
      localObject3 = localObject2;
      if (!(localObject2 instanceof bdxz)) {
        break;
      }
      localObject5 = (bdxz)localObject2;
      paramJSONObject = paramJSONObject.optJSONArray("children");
      j = paramJSONObject.length();
      i = 0;
      for (;;)
      {
        localObject3 = localObject2;
        if (i >= j) {
          break;
        }
        localObject3 = a(parambdyb, paramJSONObject.getJSONObject(i), parambdxz);
        if (localObject3 != null) {
          ((bdxz)localObject5).a((bdxv)localObject3);
        }
        i += 1;
      }
      if (((String)localObject3).equals("right"))
      {
        ((bdxv)localObject2).c(1);
        break label1028;
      }
      if (!((String)localObject3).equals("center")) {
        break label1028;
      }
      ((bdxv)localObject2).c(2);
      break label1028;
      label1180:
      if (((String)localObject3).equals("bottom")) {
        ((bdxv)localObject2).d(1);
      } else if (((String)localObject3).equals("center")) {
        ((bdxv)localObject2).d(2);
      }
    }
  }
  
  private bdxz a(bdyb parambdyb, String paramString)
  {
    Object localObject1;
    if ((parambdyb instanceof SpriteGLView))
    {
      localObject1 = new bdze((SpriteGLView)parambdyb);
      if (paramString != null) {
        break label43;
      }
    }
    for (;;)
    {
      return localObject1;
      localObject1 = new bdzs((SpriteNativeView)parambdyb);
      break;
      try
      {
        label43:
        paramString = new JSONObject(paramString);
        Object localObject2 = paramString.optJSONObject("size");
        int i = ((JSONObject)localObject2).optInt("width");
        int j = ((JSONObject)localObject2).optInt("height");
        this.jdField_a_of_type_Float = (this.jdField_a_of_type_Int / i);
        if (this.jdField_a_of_type_Boolean)
        {
          localObject2 = ((ViewGroup)parambdyb).getLayoutParams();
          ((ViewGroup.LayoutParams)localObject2).width = this.jdField_a_of_type_Int;
          ((ViewGroup.LayoutParams)localObject2).height = ((int)(j * this.jdField_a_of_type_Float));
          ((ViewGroup)parambdyb).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          ((bdxv)localObject1).c(this.jdField_a_of_type_Float);
          if (this.jdField_a_of_type_Bdyv != null) {
            this.jdField_a_of_type_Bdyv.a(((ViewGroup.LayoutParams)localObject2).width, ((ViewGroup.LayoutParams)localObject2).height);
          }
        }
        paramString = paramString.optJSONArray("scene");
        if (paramString != null)
        {
          j = paramString.length();
          i = 0;
          while (i < j)
          {
            localObject2 = a(parambdyb, paramString.getJSONObject(i), (bdxz)localObject1);
            if (localObject2 != null) {
              ((bdxz)localObject1).a((bdxv)localObject2);
            }
            i += 1;
          }
          if (!QLog.isColorLevel()) {}
        }
      }
      catch (Exception parambdyb) {}
    }
    QLog.e("SceneBuilder", 2, "buildFromJson" + QLog.getStackTraceString(parambdyb));
    return localObject1;
  }
  
  private bdyd a(JSONObject paramJSONObject)
  {
    Object localObject1 = null;
    JSONObject localJSONObject = null;
    Object localObject2 = paramJSONObject.optString("type");
    String str = paramJSONObject.optString("timeType");
    int j = paramJSONObject.optInt("duration");
    if (((String)localObject2).equals("sequence")) {
      localObject1 = new bdym(a(paramJSONObject.optJSONArray("actions")));
    }
    label513:
    label516:
    for (;;)
    {
      if (localObject1 != null)
      {
        ((bdyd)localObject1).jdField_a_of_type_Boolean = paramJSONObject.optBoolean("isRepeat");
        if (str != null)
        {
          if (!str.equals("linear")) {
            break label473;
          }
          ((bdyd)localObject1).e = 0;
        }
        label102:
        if ((paramJSONObject.optBoolean("autoClose", false)) && (this.jdField_a_of_type_Bdyy != null)) {
          ((bdyd)localObject1).a(new bdyq(this));
        }
      }
      return localObject1;
      if (((String)localObject2).equals("delay"))
      {
        localObject1 = new bdyf(j);
      }
      else
      {
        if (((String)localObject2).equals("position"))
        {
          localJSONObject = paramJSONObject.optJSONObject("from");
          localObject2 = paramJSONObject.optJSONObject("to");
          if ((this.jdField_a_of_type_Bdyr == null) || (!"$POSITIONX$".equals(((JSONObject)localObject2).optString("x")))) {
            break label513;
          }
          bdyc[] arrayOfbdyc = this.jdField_a_of_type_Bdyr.a(localJSONObject, (JSONObject)localObject2, this.jdField_a_of_type_Float);
          if ((arrayOfbdyc == null) || (arrayOfbdyc.length != 2)) {
            break label513;
          }
          localObject1 = new bdyh(j, arrayOfbdyc[0].jdField_a_of_type_Float, arrayOfbdyc[0].b, arrayOfbdyc[1].jdField_a_of_type_Float, arrayOfbdyc[1].b);
        }
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            break label516;
          }
          localObject1 = new bdyh(j, (float)localJSONObject.optDouble("x"), (float)localJSONObject.optDouble("y"), (float)((JSONObject)localObject2).optDouble("x"), (float)((JSONObject)localObject2).optDouble("y"));
          break;
          if (((String)localObject2).equals("scale"))
          {
            localObject1 = new bdyl(j, (float)paramJSONObject.optDouble("from", 1.0D), (float)paramJSONObject.optDouble("to", 1.0D));
            break;
          }
          if (((String)localObject2).equals("alpha"))
          {
            localObject1 = new bdyj(j, (int)(paramJSONObject.optDouble("from", 1.0D) * 255.0D), (int)(paramJSONObject.optDouble("to", 1.0D) * 255.0D));
            break;
          }
          localObject1 = localJSONObject;
          if (!((String)localObject2).equals("rotate")) {
            break;
          }
          localObject1 = new bdyk(j, paramJSONObject.optInt("from", 0), paramJSONObject.optInt("to", 0));
          break;
          label473:
          if (str.equals("easeIn"))
          {
            ((bdyd)localObject1).e = 1;
            break label102;
          }
          if (!str.equals("easeOut")) {
            break label102;
          }
          ((bdyd)localObject1).e = 2;
          break label102;
        }
      }
    }
  }
  
  public static String a(int paramInt, String paramString, Paint paramPaint)
  {
    String str2 = "";
    if (paramInt <= 0) {}
    float f;
    do
    {
      return paramString;
      f = paramPaint.measureText("...");
    } while ((int)Math.ceil(paramPaint.measureText(paramString)) <= paramInt);
    int i = paramString.length() - 1;
    for (;;)
    {
      String str1 = str2;
      if (i > 0)
      {
        if ((int)Math.ceil(paramPaint.measureText(paramString, 0, i) + f) <= paramInt) {
          str1 = paramString.substring(0, i) + "...";
        }
      }
      else {
        return str1;
      }
      i -= 1;
    }
  }
  
  public static boolean a(File paramFile)
  {
    StringBuffer localStringBuffer;
    Object localObject;
    if (paramFile.exists())
    {
      localStringBuffer = new StringBuffer();
      localStringBuffer.append(paramFile.getAbsolutePath()).append(File.separator).append("check.ini");
      localObject = new File(localStringBuffer.toString());
      if (((File)localObject).exists()) {}
    }
    else
    {
      return false;
    }
    for (;;)
    {
      int i;
      try
      {
        localObject = FileUtils.readFileToString((File)localObject);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        localObject = ((String)localObject).split("&");
        if (localObject == null) {
          break;
        }
        i = 0;
        if (i >= localObject.length) {
          break label225;
        }
        if (localObject[i].startsWith("﻿")) {
          localObject[i] = localObject[i].replace("﻿", "");
        }
        localStringBuffer.setLength(0);
        localStringBuffer.append(paramFile.getAbsolutePath()).append(File.separator).append(localObject[i]);
        File localFile = new File(localStringBuffer.toString());
        if (localFile.exists()) {
          break label218;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("SceneBuilder", 2, "isAnimationPackageValid File not exist:" + localFile.getName());
        return false;
      }
      catch (IOException paramFile) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("SceneBuilder", 2, "isAnimationPackageValid IOException");
      return false;
      label218:
      i += 1;
    }
    label225:
    return true;
  }
  
  private bdyd[] a(JSONArray paramJSONArray)
  {
    int j = paramJSONArray.length();
    bdyd[] arrayOfbdyd = new bdyd[j];
    int i = 0;
    while (i < j)
    {
      arrayOfbdyd[i] = a(paramJSONArray.optJSONObject(i));
      i += 1;
    }
    return arrayOfbdyd;
  }
  
  private static String b(String paramString)
  {
    try
    {
      localInputStreamReader = new InputStreamReader(new FileInputStream(new File(paramString)));
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        label66:
        localBufferedReader = null;
        InputStreamReader localInputStreamReader = null;
      }
    }
    try
    {
      localBufferedReader = new BufferedReader(localInputStreamReader);
      try
      {
        paramString = new StringBuilder();
        for (;;)
        {
          String str = localBufferedReader.readLine();
          if (str == null) {
            break;
          }
          paramString.append(str);
          paramString.append('\n');
        }
        paramString.printStackTrace();
      }
      catch (Exception paramString) {}
    }
    catch (Exception paramString)
    {
      localBufferedReader = null;
      break label66;
    }
    if (localBufferedReader != null) {}
    try
    {
      localBufferedReader.close();
      if (localInputStreamReader != null) {}
      try
      {
        localInputStreamReader.close();
        return null;
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      localBufferedReader.close();
      localInputStreamReader.close();
      paramString = paramString.toString();
      return paramString;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public bdyn a(int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public bdyn a(bdys parambdys)
  {
    this.jdField_a_of_type_Bdys = parambdys;
    return this;
  }
  
  public bdyn a(bdyt parambdyt)
  {
    this.jdField_a_of_type_Bdyt = parambdyt;
    return this;
  }
  
  public bdyn a(bdyu parambdyu)
  {
    this.jdField_a_of_type_Bdyu = parambdyu;
    return this;
  }
  
  public bdyn a(bdyv parambdyv)
  {
    this.jdField_a_of_type_Bdyv = parambdyv;
    return this;
  }
  
  public bdyn a(bdyy parambdyy)
  {
    this.jdField_a_of_type_Bdyy = parambdyy;
    return this;
  }
  
  public bdyn a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public void a(bdyb parambdyb, bdyw parambdyw)
  {
    ThreadManager.post(new SceneBuilder.1(this, parambdyb, parambdyw), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdyn
 * JD-Core Version:    0.7.0.1
 */