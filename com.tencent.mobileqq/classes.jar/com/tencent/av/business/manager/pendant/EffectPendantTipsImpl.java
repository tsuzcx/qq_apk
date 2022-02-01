package com.tencent.av.business.manager.pendant;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;

public class EffectPendantTipsImpl
  implements EffectPendantTips
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray;
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  
  public EffectPendantTipsImpl(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(PTFaceAttr.PTExpression.MOUTH_OPEN.value, 2131695468);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(PTFaceAttr.PTExpression.EYEBROWS_RAISE.value, 2131695466);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(PTFaceAttr.PTExpression.BLINK.value, 2131695465);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(PTFaceAttr.PTExpression.HEAD_SHAKE.value, 2131695469);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(PTFaceAttr.PTExpression.KISS.value, 2131695467);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(100, 2131695455);
  }
  
  private void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new EffectPendantTipsImpl.5(this, paramString));
  }
  
  public String a(Context paramContext, int paramInt)
  {
    paramInt = this.jdField_a_of_type_AndroidUtilSparseIntArray.get(paramInt);
    if (paramInt > 0) {
      return paramContext.getResources().getString(paramInt);
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new EffectPendantTipsImpl.2(this, paramInt));
  }
  
  public void a(int paramInt, EffectPendantTips.ClearErrorTipsCallback paramClearErrorTipsCallback)
  {
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new EffectPendantTipsImpl.3(this, paramClearErrorTipsCallback), paramInt);
  }
  
  public void a(Drawable paramDrawable, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new EffectPendantTipsImpl.1(this, paramString, paramDrawable));
  }
  
  public void a(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setTipsManager, app[");
      localStringBuilder.append(paramVideoAppInterface);
      localStringBuilder.append("]");
      QLog.i("EffectPendantTipsImpl", 2, localStringBuilder.toString());
    }
  }
  
  public void a(String paramString)
  {
    c(paramString);
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new EffectPendantTipsImpl.4(this), paramInt);
  }
  
  public void b(String paramString)
  {
    c(paramString);
  }
  
  public void c(int paramInt)
  {
    a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.pendant.EffectPendantTipsImpl
 * JD-Core Version:    0.7.0.1
 */