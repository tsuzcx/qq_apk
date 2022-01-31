package com.tencent.av.business.manager.magicface;

import android.graphics.Rect;
import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.mobileqq.util.JSONUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class MagicfaceData
{
  protected MagicfaceDataAudioJason a;
  protected MagicfaceDataVideoJason a;
  protected String a;
  protected Map a;
  protected Rect b;
  protected String b;
  protected int c;
  protected int d;
  
  public MagicfaceData(String paramString1, String paramString2, String paramString3)
  {
    AVLog.c("AVMagicfaceData", "init|config=" + paramString2 + "|" + paramString3 + "|" + paramString1);
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_JavaLangString = paramString3;
    try
    {
      paramString1 = new JSONObject(paramString1);
      this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason = ((MagicfaceDataVideoJason)JSONUtils.a(paramString1.getJSONObject("video"), MagicfaceDataVideoJason.class));
      if (paramString1.has("audio")) {
        this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataAudioJason = ((MagicfaceDataAudioJason)JSONUtils.a(paramString1.getJSONObject("audio"), MagicfaceDataAudioJason.class));
      }
      this.jdField_a_of_type_JavaUtilMap = new HashMap();
      if (paramString1.has("pendant"))
      {
        paramString1 = paramString1.getJSONArray("pendant");
        int i = 0;
        while (i < paramString1.length())
        {
          paramString2 = (MagicfaceDataPendantJason)JSONUtils.a((JSONObject)paramString1.get(i), MagicfaceDataPendantJason.class);
          if ((paramString2 != null) && (!TextUtils.isEmpty(paramString2.name)))
          {
            AVLog.e("AVMagicfaceData", "Pendant: " + paramString2.toString());
            paramString2.duration *= 1000;
            this.jdField_a_of_type_JavaUtilMap.put(paramString2.name, paramString2);
          }
          i += 1;
        }
      }
      return;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
      if (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason == null)
      {
        AVLog.e("AVMagicfaceData", "MagicfaceData error!");
        this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason = new MagicfaceDataVideoJason();
      }
      if (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataAudioJason == null) {
        this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataAudioJason = new MagicfaceDataAudioJason();
      }
      if (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.persistent)
      {
        this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.repeat_count = 50000;
        if (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.frame_count == 0) {
          this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.frame_count = 3;
        }
        this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataAudioJason.is_repeat = true;
      }
      AVLog.e("AVMagicfaceData", "MagicfaceData:: " + this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.toString());
      this.c = this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.frame_count;
      this.jdField_b_of_type_AndroidGraphicsRect = new Rect(this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.location_x, this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.location_y, this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.location_x + this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.width, this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.location_y + this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.height);
    }
  }
  
  protected abstract int a();
  
  abstract String a(int paramInt);
  
  protected abstract void a();
  
  protected abstract void a(int paramInt1, int paramInt2);
  
  public boolean a(MagicfaceData paramMagicfaceData)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramMagicfaceData != null)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        if (!TextUtils.isEmpty(paramMagicfaceData.jdField_b_of_type_JavaLangString))
        {
          bool1 = bool2;
          if (!paramMagicfaceData.jdField_b_of_type_JavaLangString.equalsIgnoreCase("face")) {}
        }
        else
        {
          bool1 = bool2;
          if (this.jdField_b_of_type_JavaLangString.equalsIgnoreCase("pendant")) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public abstract void b();
  
  public boolean b()
  {
    return this.jdField_b_of_type_JavaLangString.equalsIgnoreCase("face");
  }
  
  public boolean c()
  {
    return this.jdField_b_of_type_JavaLangString.equalsIgnoreCase("pendant");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.business.manager.magicface.MagicfaceData
 * JD-Core Version:    0.7.0.1
 */