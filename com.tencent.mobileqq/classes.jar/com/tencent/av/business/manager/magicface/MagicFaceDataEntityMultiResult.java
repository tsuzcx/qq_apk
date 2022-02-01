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
    boolean bool2 = false;
    this.jdField_b_of_type_Int = 0;
    try
    {
      paramVideoAppInterface = new JSONObject(paramString3);
      if (paramVideoAppInterface.has("multiresult")) {
        this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataMultiResultJason = ((MagicfaceDataMultiResultJason)JSONUtils.a(paramVideoAppInterface.getJSONObject("multiresult"), MagicfaceDataMultiResultJason.class));
      }
    }
    catch (JSONException paramVideoAppInterface)
    {
      paramVideoAppInterface.printStackTrace();
    }
    if (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataMultiResultJason == null) {
      this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataMultiResultJason = new MagicfaceDataMultiResultJason();
    }
    paramVideoAppInterface = new StringBuilder();
    paramVideoAppInterface.append("multi: ");
    paramVideoAppInterface.append(this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataMultiResultJason.toString());
    AVLog.printErrorLog("MagicFaceDataEntityMultiResult", paramVideoAppInterface.toString());
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect(this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataMultiResultJason.divers_x, this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataMultiResultJason.divers_y, this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataMultiResultJason.divers_x + this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataMultiResultJason.divers_wid, this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataMultiResultJason.divers_y + this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataMultiResultJason.divers_hei);
    boolean bool1;
    if ((!paramBoolean) || (!this.jdField_a_of_type_JavaUtilBitSet.get(1)))
    {
      bool1 = bool2;
      if (!paramBoolean)
      {
        bool1 = bool2;
        if (!this.jdField_a_of_type_JavaUtilBitSet.get(0)) {}
      }
    }
    else
    {
      bool1 = true;
    }
    this.jdField_a_of_type_Boolean = bool1;
    AVLog.printColorLog("MagicFaceDataEntityMultiResult", "MagicFaceDataEntityMultiResult constructor:");
  }
  
  private String a(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" getResultString:");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("|");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataMultiResultJason.divers_ani_start);
    AVLog.printColorLog("MagicFaceDataEntityMultiResult", localStringBuilder.toString());
    if (paramInt2 != 0)
    {
      if (paramInt2 != 1) {
        return "";
      }
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
        if (!this.jdField_b_of_type_Boolean)
        {
          paramMagicfaceDataPendantJason = new StringBuilder();
          paramMagicfaceDataPendantJason.append(paramString);
          paramMagicfaceDataPendantJason.append("_mirror");
          str = paramMagicfaceDataPendantJason.toString();
        }
      }
    }
    return str;
  }
  
  private void a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 4;
    } else {
      i = 2;
    }
    int k = i * 64 * 2;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > k) && (this.jdField_a_of_type_AndroidGraphicsRect != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isShot:");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      localStringBuilder.append("|");
      localStringBuilder.append(this.d);
      localStringBuilder.append("|");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataMultiResultJason.divers_ani_start);
      localStringBuilder.append("|");
      localStringBuilder.append(this.jdField_a_of_type_AndroidGraphicsRect.toString());
      localStringBuilder.append("|");
      localStringBuilder.append(paramArrayOfByte.length);
      AVLog.printColorLog("MagicFaceDataEntityMultiResult", localStringBuilder.toString());
      if ((this.jdField_b_of_type_Int == 0) && (this.d >= this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataMultiResultJason.divers_ani_start - 2) && (this.d < this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataMultiResultJason.divers_ani_start))
      {
        paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
        int j;
        if (paramBoolean) {
          j = paramArrayOfByte.getInt(k) / 1000000;
        } else {
          j = paramArrayOfByte.getShort(k);
        }
        float f1 = j;
        if (paramBoolean) {
          i = paramArrayOfByte.getInt(k + i) / 1000000;
        } else {
          i = paramArrayOfByte.getShort(k + i);
        }
        float f2 = i;
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("onReceiveFaceFeature Kill is:|");
        paramArrayOfByte.append(f1);
        paramArrayOfByte.append("|");
        paramArrayOfByte.append(f2);
        paramArrayOfByte.append("|");
        paramArrayOfByte.append(this.jdField_a_of_type_AndroidGraphicsRect.toString());
        AVLog.printColorLog("MagicFaceDataEntityMultiResult", paramArrayOfByte.toString());
        if (this.jdField_a_of_type_AndroidGraphicsRect.contains((int)f1, (int)f2)) {
          this.jdField_b_of_type_Int = 1;
        }
      }
    }
    else
    {
      AVLog.printColorLog("MagicFaceDataEntityMultiResult", "isShot ERROR");
    }
  }
  
  private int b()
  {
    int i = this.jdField_b_of_type_Int;
    if (i != 0)
    {
      if (i != 1) {
        return 0;
      }
      return this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataMultiResultJason.divers_ani_hit_frame;
    }
    return this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataMultiResultJason.divers_ani_miss_frame;
  }
  
  private String c()
  {
    int i = this.jdField_b_of_type_Int;
    if (i != 0)
    {
      if (i != 1) {
        return null;
      }
      return "hit";
    }
    return "miss";
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
    boolean bool = this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.hasMirrorRes;
    Object localObject = "";
    if (bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append("_");
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      if (this.jdField_a_of_type_Boolean) {
        localObject = "mirror";
      } else {
        localObject = "normal";
      }
      localStringBuilder.append((String)localObject);
      localObject = localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getMirrorPath:");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.hasMirrorRes);
    localStringBuilder.append("|");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append("|");
    localStringBuilder.append((String)localObject);
    AVLog.printColorLog("MagicFaceDataEntityMultiResult", localStringBuilder.toString());
    return localObject;
  }
  
  public String a(int paramInt)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.common_id))
    {
      int i = a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" getResPath:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("|");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataMultiResultJason.divers_ani_start);
      localStringBuilder.append("|");
      localStringBuilder.append(i);
      AVLog.printColorLog("MagicFaceDataEntityMultiResult", localStringBuilder.toString());
      if ((paramInt >= this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataMultiResultJason.divers_ani_start) && (paramInt < i))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.common_id);
        localStringBuilder.append("_");
        localStringBuilder.append(a(paramInt, this.jdField_b_of_type_Int));
        localStringBuilder.append(a());
        return localStringBuilder.toString();
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.common_id);
      localStringBuilder.append(a());
      return localStringBuilder.toString();
    }
    return super.a(paramInt);
  }
  
  protected String a(MagicfaceDataPendantJason paramMagicfaceDataPendantJason)
  {
    String str = super.a(paramMagicfaceDataPendantJason);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getDecorateName :");
    ((StringBuilder)localObject).append(paramMagicfaceDataPendantJason.toString());
    AVLog.printColorLog("MagicFaceDataEntityMultiResult", ((StringBuilder)localObject).toString());
    localObject = str;
    if (!TextUtils.isEmpty(str)) {
      if (!TextUtils.isEmpty(paramMagicfaceDataPendantJason.trigger))
      {
        localObject = c();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getDecorateName 2:");
        localStringBuilder.append(paramMagicfaceDataPendantJason.trigger);
        localStringBuilder.append("|");
        localStringBuilder.append((String)localObject);
        AVLog.printColorLog("MagicFaceDataEntityMultiResult", localStringBuilder.toString());
        if (paramMagicfaceDataPendantJason.trigger.equals(localObject)) {
          paramMagicfaceDataPendantJason = a(paramMagicfaceDataPendantJason, str);
        } else {
          paramMagicfaceDataPendantJason = null;
        }
        localObject = paramMagicfaceDataPendantJason;
      }
      else
      {
        localObject = a(paramMagicfaceDataPendantJason, str);
      }
    }
    paramMagicfaceDataPendantJason = new StringBuilder();
    paramMagicfaceDataPendantJason.append("getDecorateName 3:");
    paramMagicfaceDataPendantJason.append((String)localObject);
    AVLog.printColorLog("MagicFaceDataEntityMultiResult", paramMagicfaceDataPendantJason.toString());
    return localObject;
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, short paramShort1, short paramShort2, short paramShort3, short paramShort4, boolean paramBoolean)
  {
    super.a(paramString, paramArrayOfByte, paramShort1, paramShort2, paramShort3, paramShort4, paramBoolean);
    if (this.jdField_a_of_type_JavaUtilBitSet.get(0))
    {
      if (!a(paramString)) {
        a(paramArrayOfByte, paramBoolean);
      }
    }
    else if (a(paramString)) {
      a(paramArrayOfByte, paramBoolean);
    }
  }
  
  protected void c()
  {
    super.c();
    if (this.jdField_a_of_type_JavaUtilBitSet.get(0)) {
      a(true);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("processStart:");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilBitSet.get(2));
    AVLog.printColorLog("MagicFaceDataEntityMultiResult", localStringBuilder.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.magicface.MagicFaceDataEntityMultiResult
 * JD-Core Version:    0.7.0.1
 */