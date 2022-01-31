package com.tencent.biz.qrcode.ipc;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.Pair;
import com.tencent.biz.widgets.ScannerView;
import com.tencent.biz.widgets.ScannerView.FileDecodeListener;
import com.tencent.mobileqq.app.ThreadManager;

public class QrImageScan
  implements Handler.Callback
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ScannerView.FileDecodeListener jdField_a_of_type_ComTencentBizWidgetsScannerView$FileDecodeListener;
  private String jdField_a_of_type_JavaLangString = "QR_CODE";
  private Handler b;
  
  public QrImageScan(Context paramContext, ScannerView.FileDecodeListener paramFileDecodeListener)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentBizWidgetsScannerView$FileDecodeListener = paramFileDecodeListener;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidOsHandler != null)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        this.jdField_a_of_type_AndroidOsHandler = null;
      }
      if (this.b != null)
      {
        this.b.removeCallbacksAndMessages(null);
        this.b = null;
      }
      this.jdField_a_of_type_ComTencentBizWidgetsScannerView$FileDecodeListener = null;
      this.jdField_a_of_type_AndroidContentContext = null;
      return;
    }
    finally {}
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return;
    }
    paramString = Uri.parse("file://" + paramString);
    if (this.jdField_a_of_type_AndroidOsHandler == null) {}
    try
    {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
      this.b = new Handler(this.jdField_a_of_type_AndroidContentContext.getMainLooper(), this);
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, paramString).sendToTarget();
      return;
    }
    finally {}
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      Pair localPair = null;
      if ((paramMessage.obj instanceof Uri)) {
        localPair = ScannerView.a((Uri)paramMessage.obj, this.jdField_a_of_type_AndroidContentContext);
      }
      if (localPair != null)
      {
        this.jdField_a_of_type_JavaLangString = String.valueOf(localPair.second).trim();
        if (this.b != null) {
          this.b.obtainMessage(2, localPair.first).sendToTarget();
        }
      }
      else if (this.b != null)
      {
        this.b.sendEmptyMessage(3);
        continue;
        if (this.jdField_a_of_type_ComTencentBizWidgetsScannerView$FileDecodeListener != null)
        {
          this.jdField_a_of_type_ComTencentBizWidgetsScannerView$FileDecodeListener.a(String.valueOf(paramMessage.obj));
          continue;
          if (this.jdField_a_of_type_ComTencentBizWidgetsScannerView$FileDecodeListener != null) {
            this.jdField_a_of_type_ComTencentBizWidgetsScannerView$FileDecodeListener.a();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qrcode.ipc.QrImageScan
 * JD-Core Version:    0.7.0.1
 */