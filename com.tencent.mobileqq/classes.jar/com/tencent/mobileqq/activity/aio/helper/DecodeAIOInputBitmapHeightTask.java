package com.tencent.mobileqq.activity.aio.helper;

import actn;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Paint.FontMetrics;
import android.support.v4.app.FragmentActivity;
import android.text.TextPaint;
import android.widget.EditText;
import com.tencent.mobileqq.activity.BaseChatPie;
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
    localObject2 = BitmapFactory.decodeResource(localBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources(), 2130848771, (BitmapFactory.Options)localObject2);
    float f;
    int j;
    int k;
    if (localObject2 != null)
    {
      i = actn.a(((Bitmap)localObject2).getHeight() / 2, localBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources());
      localObject2 = ((EditText)localObject1).getPaint().getFontMetrics();
      f = Math.abs(((Paint.FontMetrics)localObject2).bottom - ((Paint.FontMetrics)localObject2).top);
      j = actn.a(36.0F, localBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources());
      k = ((EditText)localObject1).getPaddingTop();
    }
    for (int i = (Math.max(j, Math.max((int)(((EditText)localObject1).getPaddingBottom() + k + f), i)) - localBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimensionPixelSize(2131297946)) / 2;; i = 0)
    {
      i = Math.max(i, 0);
      localObject1 = localBaseChatPie.a();
      if (localObject1 == null) {
        break;
      }
      ((MqqHandler)localObject1).post(new DecodeAIOInputBitmapHeightTask.1(this, localBaseChatPie, i));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.DecodeAIOInputBitmapHeightTask
 * JD-Core Version:    0.7.0.1
 */