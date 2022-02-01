package com.tencent.biz.webviewplugin;

import abcr;
import android.app.Activity;
import android.graphics.Bitmap;
import bhni;
import bhsx;
import biau;
import java.lang.ref.WeakReference;

class Share$2$1
  implements Runnable
{
  Share$2$1(Share.2 param2, Bitmap paramBitmap) {}
  
  public void run()
  {
    bhni localbhni = (bhni)this.jdField_a_of_type_ComTencentBizWebviewpluginShare$2.this$0.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localbhni != null) && ((localbhni instanceof bhsx)) && (((bhsx)localbhni).isActivityResume()) && (!this.jdField_a_of_type_ComTencentBizWebviewpluginShare$2.this$0.jdField_a_of_type_AndroidAppActivity.isFinishing()))
    {
      if ((this.jdField_a_of_type_ComTencentBizWebviewpluginShare$2.this$0.jdField_a_of_type_Biau != null) && (this.jdField_a_of_type_ComTencentBizWebviewpluginShare$2.this$0.jdField_a_of_type_Biau.isShowing())) {
        this.jdField_a_of_type_ComTencentBizWebviewpluginShare$2.this$0.jdField_a_of_type_Biau.dismiss();
      }
      abcr.a(this.jdField_a_of_type_ComTencentBizWebviewpluginShare$2.this$0, this.jdField_a_of_type_ComTencentBizWebviewpluginShare$2.a, this.jdField_a_of_type_ComTencentBizWebviewpluginShare$2.this$0.e, this.jdField_a_of_type_ComTencentBizWebviewpluginShare$2.this$0.h, this.jdField_a_of_type_ComTencentBizWebviewpluginShare$2.this$0.b, this.jdField_a_of_type_ComTencentBizWebviewpluginShare$2.this$0.i, this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.Share.2.1
 * JD-Core Version:    0.7.0.1
 */