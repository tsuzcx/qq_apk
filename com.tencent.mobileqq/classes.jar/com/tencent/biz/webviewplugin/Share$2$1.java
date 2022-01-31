package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.graphics.Bitmap;
import bccw;
import bcij;
import bcqf;
import java.lang.ref.WeakReference;
import xmq;

class Share$2$1
  implements Runnable
{
  Share$2$1(Share.2 param2, Bitmap paramBitmap) {}
  
  public void run()
  {
    bccw localbccw = (bccw)this.jdField_a_of_type_ComTencentBizWebviewpluginShare$2.this$0.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localbccw != null) && ((localbccw instanceof bcij)) && (((bcij)localbccw).b()) && (!this.jdField_a_of_type_ComTencentBizWebviewpluginShare$2.this$0.jdField_a_of_type_AndroidAppActivity.isFinishing()))
    {
      if ((this.jdField_a_of_type_ComTencentBizWebviewpluginShare$2.this$0.jdField_a_of_type_Bcqf != null) && (this.jdField_a_of_type_ComTencentBizWebviewpluginShare$2.this$0.jdField_a_of_type_Bcqf.isShowing())) {
        this.jdField_a_of_type_ComTencentBizWebviewpluginShare$2.this$0.jdField_a_of_type_Bcqf.dismiss();
      }
      xmq.a(this.jdField_a_of_type_ComTencentBizWebviewpluginShare$2.this$0, this.jdField_a_of_type_ComTencentBizWebviewpluginShare$2.a, this.jdField_a_of_type_ComTencentBizWebviewpluginShare$2.this$0.e, this.jdField_a_of_type_ComTencentBizWebviewpluginShare$2.this$0.h, this.jdField_a_of_type_ComTencentBizWebviewpluginShare$2.this$0.b, this.jdField_a_of_type_ComTencentBizWebviewpluginShare$2.this$0.i, this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.Share.2.1
 * JD-Core Version:    0.7.0.1
 */