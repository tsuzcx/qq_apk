package com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui;

import agty;
import aguc;
import agvs;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import bajq;
import bfod;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.qphone.base.util.QLog;

public class SpringBigInsertPage$4$1
  implements Runnable
{
  public SpringBigInsertPage$4$1(aguc paramaguc, PreloadManager.PathResult paramPathResult) {}
  
  public void run()
  {
    QLog.d("SpringBigInsertPage", 2, "show insert page...");
    bfod.a(agty.a(this.jdField_a_of_type_Aguc.a));
    agty.a(this.jdField_a_of_type_Aguc.a).addView(agty.a(this.jdField_a_of_type_Aguc.a));
    Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
    localObject1 = URLDrawable.getFileDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager$PathResult.filePath, (URLDrawable.URLDrawableOptions)localObject1);
    try
    {
      Object localObject2 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
      BitmapFactory.decodeFile(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager$PathResult.filePath, (BitmapFactory.Options)localObject2);
      QLog.d("SpringBigInsertPage", 2, "bitmap w: " + ((BitmapFactory.Options)localObject2).outWidth + ", h: " + ((BitmapFactory.Options)localObject2).outHeight);
      int i = bajq.a();
      i = (int)(((BitmapFactory.Options)localObject2).outHeight * 1.0F / ((BitmapFactory.Options)localObject2).outWidth * i);
      if (i > 0)
      {
        QLog.d("SpringBigInsertPage", 2, "calc height: " + i);
        localObject2 = agty.a(this.jdField_a_of_type_Aguc.a).getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).height = i;
        agty.a(this.jdField_a_of_type_Aguc.a).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
    agty.a(this.jdField_a_of_type_Aguc.a).setBackgroundDrawable((Drawable)localObject1);
    agty.a(agty.b(this.jdField_a_of_type_Aguc.a));
    agvs.a("sq.cptp", 0, 0, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui.SpringBigInsertPage.4.1
 * JD-Core Version:    0.7.0.1
 */