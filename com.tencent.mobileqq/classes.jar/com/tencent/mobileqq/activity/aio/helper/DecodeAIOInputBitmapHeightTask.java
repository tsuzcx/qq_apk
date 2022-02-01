package com.tencent.mobileqq.activity.aio.helper;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Paint.FontMetrics;
import android.text.TextPaint;
import android.widget.EditText;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class DecodeAIOInputBitmapHeightTask
  implements Runnable
{
  private WeakReference<BaseChatPie> a;
  
  public DecodeAIOInputBitmapHeightTask(BaseChatPie paramBaseChatPie)
  {
    this.a = new WeakReference(paramBaseChatPie);
  }
  
  public void run()
  {
    BaseChatPie localBaseChatPie = (BaseChatPie)this.a.get();
    if (localBaseChatPie == null) {
      return;
    }
    Object localObject1 = localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx;
    Object localObject2 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject2).inScaled = false;
    localObject2 = BitmapFactory.decodeResource(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources(), 2130850178, (BitmapFactory.Options)localObject2);
    if (localObject2 != null)
    {
      i = AIOUtils.b(((Bitmap)localObject2).getHeight() / 2, localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources());
      localObject2 = ((EditText)localObject1).getPaint().getFontMetrics();
      float f = Math.abs(((Paint.FontMetrics)localObject2).bottom - ((Paint.FontMetrics)localObject2).top);
      i = (Math.max(AIOUtils.b(36.0F, localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources()), Math.max((int)(((EditText)localObject1).getPaddingTop() + ((EditText)localObject1).getPaddingBottom() + f), i)) - localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDimensionPixelSize(2131298203)) / 2;
    }
    else
    {
      i = 0;
    }
    int i = Math.max(i, 0);
    localObject1 = localBaseChatPie.a();
    if (localObject1 != null) {
      ((MqqHandler)localObject1).post(new DecodeAIOInputBitmapHeightTask.1(this, localBaseChatPie, i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.DecodeAIOInputBitmapHeightTask
 * JD-Core Version:    0.7.0.1
 */