package com.tencent.biz.qrcode.ipc;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.manager.Manager;

public class QrMainProcManager
  implements Manager
{
  private Context jdField_a_of_type_AndroidContentContext;
  private VoiceScan jdField_a_of_type_ComTencentBizQrcodeIpcVoiceScan;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public QrMainProcManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentBizQrcodeIpcVoiceScan != null) {
      this.jdField_a_of_type_ComTencentBizQrcodeIpcVoiceScan.a();
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentBizQrcodeIpcVoiceScan != null) {
      this.jdField_a_of_type_ComTencentBizQrcodeIpcVoiceScan.b();
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizQrcodeIpcVoiceScan != null)
    {
      this.jdField_a_of_type_ComTencentBizQrcodeIpcVoiceScan.c();
      this.jdField_a_of_type_ComTencentBizQrcodeIpcVoiceScan = null;
    }
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return;
    case 2: 
      b();
      return;
    case 3: 
      c();
      return;
    }
    a();
  }
  
  public void a(Context paramContext, ScannerParams paramScannerParams)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if ((paramScannerParams.f) && (!paramScannerParams.d) && (this.jdField_a_of_type_ComTencentBizQrcodeIpcVoiceScan == null)) {
      this.jdField_a_of_type_ComTencentBizQrcodeIpcVoiceScan = new VoiceScan(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  public void onDestroy()
  {
    a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_AndroidContentContext = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qrcode.ipc.QrMainProcManager
 * JD-Core Version:    0.7.0.1
 */