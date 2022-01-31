package com.tencent.av.business.manager.magicface;

import android.graphics.Rect;
import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.util.JSONUtils;
import java.nio.ByteBuffer;
import java.util.BitSet;
import org.json.JSONException;
import org.json.JSONObject;

public class MagicFaceDataEntityMultiResult
  extends MagicFaceDataEntity
{
  Rect a;
  protected MagicfaceDataMultiResultJason a;
  int b;
  
  public MagicFaceDataEntityMultiResult(VideoAppInterface paramVideoAppInterface, String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt)
  {
    super(paramVideoAppInterface, paramString1, paramString2, paramString3, paramBoolean, paramInt);
    this.jdField_b_of_type_Int = 0;
    try
    {
      paramVideoAppInterface = new JSONObject(paramString3);
      if (paramVideoAppInterface.has("multiresult")) {
        this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataMultiResultJason = ((MagicfaceDataMultiResultJason)JSONUtils.a(paramVideoAppInterface.getJSONObject("multiresult"), MagicfaceDataMultiResultJason.class));
      }
      if (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataMultiResultJason == null) {
        this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataMultiResultJason = new MagicfaceDataMultiResultJason();
      }
      AVLog.e("MagicFaceDataEntityMultiResult", "multi: " + this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataMultiResultJason.toString());
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect(this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataMultiResultJason.divers_x, this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataMultiResultJason.divers_y, this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataMultiResultJason.divers_x + this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataMultiResultJason.divers_wid, this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataMultiResultJason.divers_y + this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataMultiResultJason.divers_hei);
      if (((paramBoolean) && (this.jdField_a_of_type_JavaUtilBitSet.get(1))) || ((!paramBoolean) && (this.jdField_a_of_type_JavaUtilBitSet.get(0))))
      {
        paramBoolean = true;
        this.jdField_a_of_type_Boolean = paramBoolean;
        AVLog.c("MagicFaceDataEntityMultiResult", "MagicFaceDataEntityMultiResult constructor:");
        return;
      }
    }
    catch (JSONException paramVideoAppInterface)
    {
      for (;;)
      {
        paramVideoAppInterface.printStackTrace();
        continue;
        paramBoolean = false;
      }
    }
  }
  
  private String a(int paramInt1, int paramInt2)
  {
    AVLog.c("MagicFaceDataEntityMultiResult", " getResultString:" + paramInt2 + "|" + this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataMultiResultJason.divers_ani_start);
    switch (paramInt2)
    {
    default: 
      return "";
    case 1: 
      return this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataMultiResultJason.divers_ani_hit;
    }
    return this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataMultiResultJason.divers_ani_miss;
  }
  
  private String a(MagicfaceDataPendantJason paramMagicfaceDataPendantJason, String paramString)
  {
    String str = paramString;
    if (paramMagicfaceDataPendantJason != null)
    {
      str = paramString;
      if (paramMagicfaceDataPendantJason.mirror)
      {
        str = paramString;
        if (!this.jdField_b_of_type_Boolean) {
          str = paramString + "_mirror";
        }
      }
    }
    return str;
  }
  
  private void a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    int i;
    int j;
    float f1;
    if (paramBoolean)
    {
      i = 4;
      j = i * 64 * 2;
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= j) || (this.jdField_a_of_type_AndroidGraphicsRect == null)) {
        break label291;
      }
      AVLog.c("MagicFaceDataEntityMultiResult", "isShot:" + this.jdField_b_of_type_Int + "|" + this.d + "|" + this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataMultiResultJason.divers_ani_start + "|" + this.jdField_a_of_type_AndroidGraphicsRect.toString() + "|" + paramArrayOfByte.length);
      if ((this.jdField_b_of_type_Int == 0) && (this.d >= this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataMultiResultJason.divers_ani_start - 2) && (this.d < this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataMultiResultJason.divers_ani_start))
      {
        paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
        if (!paramBoolean) {
          break label265;
        }
        f1 = paramArrayOfByte.getInt(j) / 1000000;
        label170:
        if (!paramBoolean) {
          break label276;
        }
      }
    }
    label265:
    label276:
    for (float f2 = paramArrayOfByte.getInt(j + i) / 1000000;; f2 = paramArrayOfByte.getShort(j + i))
    {
      AVLog.c("MagicFaceDataEntityMultiResult", "onReceiveFaceFeature Kill is:|" + f1 + "|" + f2 + "|" + this.jdField_a_of_type_AndroidGraphicsRect.toString());
      if (this.jdField_a_of_type_AndroidGraphicsRect.contains((int)f1, (int)f2)) {
        this.jdField_b_of_type_Int = 1;
      }
      return;
      i = 2;
      break;
      f1 = paramArrayOfByte.getShort(j);
      break label170;
    }
    label291:
    AVLog.c("MagicFaceDataEntityMultiResult", "isShot ERROR");
  }
  
  private int b()
  {
    switch (this.jdField_b_of_type_Int)
    {
    default: 
      return 0;
    case 1: 
      return this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataMultiResultJason.divers_ani_hit_frame;
    }
    return this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataMultiResultJason.divers_ani_miss_frame;
  }
  
  private String c()
  {
    switch (this.jdField_b_of_type_Int)
    {
    default: 
      return null;
    case 0: 
      return "miss";
    }
    return "hit";
  }
  
  private boolean d()
  {
    return (this.jdField_a_of_type_JavaUtilBitSet.get(1)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.tips));
  }
  
  protected int a()
  {
    return super.a() + b();
  }
  
  protected String a()
  {
    String str = "";
    StringBuilder localStringBuilder;
    if (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.hasMirrorRes)
    {
      str = "" + "_";
      localStringBuilder = new StringBuilder().append(str);
      if (!this.jdField_a_of_type_Boolean) {
        break label118;
      }
    }
    label118:
    for (str = "mirror";; str = "normal")
    {
      str = str;
      AVLog.c("MagicFaceDataEntityMultiResult", "getMirrorPath:" + this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.hasMirrorRes + "|" + this.jdField_a_of_type_Boolean + "|" + str);
      return str;
    }
  }
  
  public String a(int paramInt)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.common_id))
    {
      int i = a();
      AVLog.c("MagicFaceDataEntityMultiResult", " getResPath:" + paramInt + "|" + this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataMultiResultJason.divers_ani_start + "|" + i);
      if ((paramInt >= this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataMultiResultJason.divers_ani_start) && (paramInt < i)) {
        return this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.common_id + "_" + a(paramInt, this.jdField_b_of_type_Int) + a();
      }
      return this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.common_id + a();
    }
    return super.a(paramInt);
  }
  
  protected String a(MagicfaceDataPendantJason paramMagicfaceDataPendantJason)
  {
    String str2 = super.a(paramMagicfaceDataPendantJason);
    AVLog.c("MagicFaceDataEntityMultiResult", "getDecorateName :" + paramMagicfaceDataPendantJason.toString());
    String str1 = str2;
    if (!TextUtils.isEmpty(str2))
    {
      if (TextUtils.isEmpty(paramMagicfaceDataPendantJason.trigger)) {
        break label142;
      }
      str1 = c();
      AVLog.c("MagicFaceDataEntityMultiResult", "getDecorateName 2:" + paramMagicfaceDataPendantJason.trigger + "|" + str1);
      if (!paramMagicfaceDataPendantJason.trigger.equals(str1)) {
        break label137;
      }
      str1 = a(paramMagicfaceDataPendantJason, str2);
    }
    for (;;)
    {
      AVLog.c("MagicFaceDataEntityMultiResult", "getDecorateName 3:" + str1);
      return str1;
      label137:
      str1 = null;
      continue;
      label142:
      str1 = a(paramMagicfaceDataPendantJason, str2);
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, short paramShort1, short paramShort2, short paramShort3, short paramShort4, boolean paramBoolean)
  {
    super.a(paramString, paramArrayOfByte, paramShort1, paramShort2, paramShort3, paramShort4, paramBoolean);
    if (this.jdField_a_of_type_JavaUtilBitSet.get(0)) {
      if (!a(paramString)) {
        a(paramArrayOfByte, paramBoolean);
      }
    }
    while (!a(paramString)) {
      return;
    }
    a(paramArrayOfByte, paramBoolean);
  }
  
  protected void c()
  {
    super.c();
    if (this.jdField_a_of_type_JavaUtilBitSet.get(0)) {
      a(true);
    }
    AVLog.c("MagicFaceDataEntityMultiResult", "processStart:" + this.jdField_a_of_type_JavaUtilBitSet.get(2));
    if ((!this.jdField_a_of_type_JavaUtilBitSet.get(2)) && (d())) {
      a(this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.tips);
    }
  }
  
  protected void d()
  {
    super.d();
    if (this.jdField_a_of_type_JavaUtilBitSet.get(0)) {
      a(false);
    }
    b(0);
    b(1);
    if (d()) {
      a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.business.manager.magicface.MagicFaceDataEntityMultiResult
 * JD-Core Version:    0.7.0.1
 */