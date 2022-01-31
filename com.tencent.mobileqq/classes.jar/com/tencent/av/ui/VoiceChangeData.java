package com.tencent.av.ui;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.funchat.AVConfigManagerBase;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import kdg;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VoiceChangeData
  extends AVConfigManagerBase
{
  private static VoiceChangeData jdField_a_of_type_ComTencentAvUiVoiceChangeData;
  public static String b;
  private final int jdField_a_of_type_Int = 1;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private boolean jdField_a_of_type_Boolean;
  private VoiceChangeData.VoiceInfo[] jdField_a_of_type_ArrayOfComTencentAvUiVoiceChangeData$VoiceInfo;
  private final int b;
  private final int c = 40;
  
  static
  {
    jdField_b_of_type_JavaLangString = "VoiceChangeData";
  }
  
  private VoiceChangeData()
  {
    super("voicechange");
    this.jdField_b_of_type_Int = 2;
  }
  
  private VoiceChangeData.VoiceInfo a(int paramInt)
  {
    VoiceChangeData.VoiceInfo[] arrayOfVoiceInfo = a();
    if (arrayOfVoiceInfo == null) {}
    for (;;)
    {
      return null;
      int j = arrayOfVoiceInfo.length;
      int i = 0;
      while (i < j)
      {
        VoiceChangeData.VoiceInfo localVoiceInfo = arrayOfVoiceInfo[i];
        if (localVoiceInfo.jdField_a_of_type_Int == paramInt) {
          return localVoiceInfo;
        }
        i += 1;
      }
    }
  }
  
  public static VoiceChangeData a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentAvUiVoiceChangeData == null) {
        jdField_a_of_type_ComTencentAvUiVoiceChangeData = new VoiceChangeData();
      }
      return jdField_a_of_type_ComTencentAvUiVoiceChangeData;
    }
    finally {}
  }
  
  public Drawable a(int paramInt, Resources paramResources, VoiceChangeData.GetDrawableCallack paramGetDrawableCallack)
  {
    AVLog.a(jdField_b_of_type_JavaLangString, "getDrawable| voiceType = " + paramInt);
    if (paramInt == 0) {
      return null;
    }
    VoiceChangeData.VoiceInfo localVoiceInfo = a(paramInt);
    if ((localVoiceInfo == null) || (TextUtils.isEmpty(localVoiceInfo.jdField_b_of_type_JavaLangString))) {
      return null;
    }
    paramInt = AIOUtils.a(40.0F, paramResources);
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = paramInt;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = paramInt;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = null;
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = null;
    localObject = URLDrawable.getDrawable(localVoiceInfo.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
    ((URLDrawable)localObject).setTag(URLDrawableDecodeHandler.a(paramInt, paramInt));
    ((URLDrawable)localObject).setDecodeHandler(URLDrawableDecodeHandler.a);
    ((URLDrawable)localObject).setURLDrawableListener(new kdg(this, paramGetDrawableCallack, (URLDrawable)localObject, paramResources, localVoiceInfo));
    if (((URLDrawable)localObject).getStatus() == 1) {
      return a((URLDrawable)localObject, paramResources);
    }
    ((URLDrawable)localObject).draw(new Canvas());
    return null;
  }
  
  public Drawable a(URLDrawable paramURLDrawable, Resources paramResources)
  {
    int i = AIOUtils.a(1.0F, paramResources);
    int j = AIOUtils.a(40.0F, paramResources);
    int k = AIOUtils.a(2.0F, paramResources);
    paramResources = Bitmap.createBitmap(j, j, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(paramResources);
    localCanvas.drawARGB(0, 0, 0, 0);
    Paint localPaint = new Paint();
    localPaint.setColor(-15550475);
    localPaint.setAntiAlias(true);
    localCanvas.drawCircle(j / 2, j / 2, j / 2 - i, localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
    localCanvas.drawCircle(j / 2, j / 2, j / 2 - k - i, localPaint);
    paramURLDrawable.setBounds(k * 2 + i, k * 2 + i, j - k * 2 - i, j - k * 2 - i);
    paramURLDrawable.draw(localCanvas);
    paramURLDrawable = new BitmapDrawable(paramResources);
    paramURLDrawable.setBounds(0, 0, j, j);
    return paramURLDrawable;
  }
  
  public VoiceChangeData.VoiceInfo[] a()
  {
    if (this.jdField_a_of_type_ArrayOfComTencentAvUiVoiceChangeData$VoiceInfo == null) {
      b(a());
    }
    if ((this.jdField_a_of_type_ArrayOfComTencentAvUiVoiceChangeData$VoiceInfo == null) && (!this.jdField_a_of_type_Boolean))
    {
      VoiceChangeDataReport.a("0X8007EFD", "");
      this.jdField_a_of_type_Boolean = true;
    }
    return this.jdField_a_of_type_ArrayOfComTencentAvUiVoiceChangeData$VoiceInfo;
  }
  
  protected void b(String paramString)
  {
    if (paramString == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_ArrayOfComTencentAvUiVoiceChangeData$VoiceInfo = null;
      try
      {
        Object localObject2 = new JSONObject(paramString);
        if (((JSONObject)localObject2).has("version")) {
          AVLog.c(jdField_b_of_type_JavaLangString, ((JSONObject)localObject2).getString("version"));
        }
        if (((JSONObject)localObject2).has("voices"))
        {
          localObject2 = ((JSONObject)localObject2).getJSONArray("voices");
          AVLog.d(jdField_b_of_type_JavaLangString, "parseConfig|voices size= " + ((JSONArray)localObject2).length());
          this.jdField_a_of_type_ArrayOfComTencentAvUiVoiceChangeData$VoiceInfo = new VoiceChangeData.VoiceInfo[((JSONArray)localObject2).length()];
          int i = 0;
          while (i < ((JSONArray)localObject2).length())
          {
            JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(i);
            VoiceChangeData.VoiceInfo localVoiceInfo = new VoiceChangeData.VoiceInfo();
            localVoiceInfo.jdField_a_of_type_JavaLangString = localJSONObject.getString("name");
            localVoiceInfo.jdField_b_of_type_JavaLangString = localJSONObject.getString("icon1");
            localVoiceInfo.c = localJSONObject.getString("icon2");
            localVoiceInfo.jdField_a_of_type_Int = Integer.parseInt(localJSONObject.getString("type"));
            localVoiceInfo.jdField_b_of_type_Int = Integer.parseInt(localJSONObject.getString("vip_level"));
            this.jdField_a_of_type_ArrayOfComTencentAvUiVoiceChangeData$VoiceInfo[i] = localVoiceInfo;
            i += 1;
          }
        }
        paramString = finally;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        AVLog.e(jdField_b_of_type_JavaLangString, "parseConfig|parse failed.context = " + paramString);
        this.jdField_a_of_type_ArrayOfComTencentAvUiVoiceChangeData$VoiceInfo = null;
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.VoiceChangeData
 * JD-Core Version:    0.7.0.1
 */