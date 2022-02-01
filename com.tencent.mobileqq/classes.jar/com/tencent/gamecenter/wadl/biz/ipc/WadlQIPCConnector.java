package com.tencent.gamecenter.wadl.biz.ipc;

import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;

public class WadlQIPCConnector
{
  private static volatile WadlQIPCConnector jdField_a_of_type_ComTencentGamecenterWadlBizIpcWadlQIPCConnector;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  
  public static WadlQIPCConnector a()
  {
    if (jdField_a_of_type_ComTencentGamecenterWadlBizIpcWadlQIPCConnector == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentGamecenterWadlBizIpcWadlQIPCConnector == null) {
        jdField_a_of_type_ComTencentGamecenterWadlBizIpcWadlQIPCConnector = new WadlQIPCConnector();
      }
      return jdField_a_of_type_ComTencentGamecenterWadlBizIpcWadlQIPCConnector;
    }
    finally {}
  }
  
  private void b()
  {
    this.b = true;
    if (QLog.isColorLevel()) {
      QLog.d("WadlQIPCConnector", 2, "begin connect:");
    }
    QIPCClientHelper.getInstance().getClient().addListener(new WadlQIPCConnector.1(this));
    long l = System.currentTimeMillis();
    QIPCClientHelper.getInstance().getClient().connect(new WadlQIPCConnector.2(this, l));
  }
  
  public void a()
  {
    if ((!this.jdField_a_of_type_Boolean) && (!this.b)) {
      b();
    }
    if (!this.jdField_a_of_type_Boolean) {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        boolean bool = this.jdField_a_of_type_Boolean;
        if (!bool) {}
        try
        {
          this.jdField_a_of_type_JavaLangObject.wait(500L);
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.ipc.WadlQIPCConnector
 * JD-Core Version:    0.7.0.1
 */