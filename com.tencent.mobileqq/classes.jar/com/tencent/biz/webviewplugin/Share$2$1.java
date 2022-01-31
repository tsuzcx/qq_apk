package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.graphics.Bitmap;
import begg;
import belt;
import bety;
import java.lang.ref.WeakReference;
import zfy;

class Share$2$1
  implements Runnable
{
  Share$2$1(Share.2 param2, Bitmap paramBitmap) {}
  
  public void run()
  {
    begg localbegg = (begg)this.jdField_a_of_type_ComTencentBizWebviewpluginShare$2.this$0.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localbegg != null) && ((localbegg instanceof belt)) && (((belt)localbegg).b()) && (!this.jdField_a_of_type_ComTencentBizWebviewpluginShare$2.this$0.jdField_a_of_type_AndroidAppActivity.isFinishing()))
    {
      if ((this.jdField_a_of_type_ComTencentBizWebviewpluginShare$2.this$0.jdField_a_of_type_Bety != null) && (this.jdField_a_of_type_ComTencentBizWebviewpluginShare$2.this$0.jdField_a_of_type_Bety.isShowing())) {
        this.jdField_a_of_type_ComTencentBizWebviewpluginShare$2.this$0.jdField_a_of_type_Bety.dismiss();
      }
      zfy.a(this.jdField_a_of_type_ComTencentBizWebviewpluginShare$2.this$0, this.jdField_a_of_type_ComTencentBizWebviewpluginShare$2.a, this.jdField_a_of_type_ComTencentBizWebviewpluginShare$2.this$0.e, this.jdField_a_of_type_ComTencentBizWebviewpluginShare$2.this$0.h, this.jdField_a_of_type_ComTencentBizWebviewpluginShare$2.this$0.b, this.jdField_a_of_type_ComTencentBizWebviewpluginShare$2.this$0.i, this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.Share.2.1
 * JD-Core Version:    0.7.0.1
 */