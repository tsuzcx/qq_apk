package com.tencent.av.business.manager.pendant;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.SparseIntArray;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.ResidentTip;
import com.tencent.av.utils.TipsManager;
import com.tencent.ttpic.util.VideoMaterialUtil.TRIGGER_TYPE;
import jgp;
import jgq;
import jgr;
import jgs;
import jgt;

public class EffectPendantTips
{
  public static int a;
  private Context jdField_a_of_type_AndroidContentContext;
  Handler jdField_a_of_type_AndroidOsHandler;
  SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray;
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_Int = 100;
  }
  
  public EffectPendantTips(Context paramContext, TipsManager paramTipsManager)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_Boolean = paramContext.getSharedPreferences("effects_face_file", 4).getBoolean("key_frist_use_Face" + VideoController.a().a().getCurrentAccountUin(), false);
    this.jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(VideoMaterialUtil.TRIGGER_TYPE.MOUTH_OPEN.value, 2131429255);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(VideoMaterialUtil.TRIGGER_TYPE.EYEBROWS_RAISE.value, 2131429256);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(VideoMaterialUtil.TRIGGER_TYPE.BLINK.value, 2131429257);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(VideoMaterialUtil.TRIGGER_TYPE.HEAD_SHAKE.value, 2131429258);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(VideoMaterialUtil.TRIGGER_TYPE.KISS.value, 2131429259);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(jdField_a_of_type_Int, 2131429260);
  }
  
  public String a(Context paramContext, int paramInt)
  {
    Integer localInteger = Integer.valueOf(this.jdField_a_of_type_AndroidUtilSparseIntArray.get(paramInt));
    if (localInteger != null) {
      return paramContext.getResources().getString(localInteger.intValue());
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    a(78, paramInt);
    b(78, 1500);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new jgs(this, paramInt2, paramInt1));
  }
  
  public void a(int paramInt, Drawable paramDrawable, String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new jgq(this, paramString, paramInt, paramDrawable));
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new jgp(this, paramString, paramInt));
  }
  
  public void a(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new jgr(this, paramInt));
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new jgt(this, paramInt1), paramInt2);
  }
  
  public void b(int paramInt, Drawable paramDrawable, String paramString)
  {
    AVLog.c("EffectPendantTips", "notifyTipsShowEvent :" + paramInt + "|" + paramString);
    paramString = new ResidentTip(paramInt, paramString);
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(6003), paramString, paramDrawable });
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    AVLog.c("EffectPendantTips", "notifyTipsShowEvent :" + paramInt + "|" + paramString);
    paramString = new ResidentTip(paramInt, paramString);
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(6000), paramString });
    }
  }
  
  public void c(int paramInt)
  {
    AVLog.c("EffectPendantTips", "notifyTipsHideEvent :" + paramInt);
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(6004), Integer.valueOf(paramInt) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.business.manager.pendant.EffectPendantTips
 * JD-Core Version:    0.7.0.1
 */