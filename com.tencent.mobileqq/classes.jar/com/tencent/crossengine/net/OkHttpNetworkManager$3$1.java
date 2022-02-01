package com.tencent.crossengine.net;

import java.io.OutputStream;
import okhttp3.RequestBody;

class OkHttpNetworkManager$3$1
  extends OutputStream
{
  OkHttpNetworkManager$3$1(OkHttpNetworkManager.3 param3, OutputStream paramOutputStream) {}
  
  public void close()
  {
    this.jdField_a_of_type_JavaIoOutputStream.close();
  }
  
  public void flush()
  {
    this.jdField_a_of_type_JavaIoOutputStream.flush();
  }
  
  public void write(int paramInt)
  {
    this.jdField_a_of_type_JavaIoOutputStream.write(paramInt);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaIoOutputStream.write(paramArrayOfByte, paramInt1, paramInt2);
    if (this.jdField_a_of_type_ComTencentCrossengineNetOkHttpNetworkManager$3.jdField_a_of_type_ArrayOfLong[0] == 0L) {
      this.jdField_a_of_type_ComTencentCrossengineNetOkHttpNetworkManager$3.jdField_a_of_type_ArrayOfLong[0] = this.jdField_a_of_type_ComTencentCrossengineNetOkHttpNetworkManager$3.jdField_a_of_type_Okhttp3RequestBody.contentLength();
    }
    paramArrayOfByte = this.jdField_a_of_type_ComTencentCrossengineNetOkHttpNetworkManager$3.jdField_a_of_type_ArrayOfLong;
    paramArrayOfByte[1] += paramInt2;
    this.jdField_a_of_type_ComTencentCrossengineNetOkHttpNetworkManager$3.jdField_a_of_type_ComTencentCrossengineNetNetworkManager$Callback.onProgress(this.jdField_a_of_type_ComTencentCrossengineNetOkHttpNetworkManager$3.jdField_a_of_type_ArrayOfLong[3], this.jdField_a_of_type_ComTencentCrossengineNetOkHttpNetworkManager$3.jdField_a_of_type_ArrayOfLong[2], this.jdField_a_of_type_ComTencentCrossengineNetOkHttpNetworkManager$3.jdField_a_of_type_ArrayOfLong[1], this.jdField_a_of_type_ComTencentCrossengineNetOkHttpNetworkManager$3.jdField_a_of_type_ArrayOfLong[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.crossengine.net.OkHttpNetworkManager.3.1
 * JD-Core Version:    0.7.0.1
 */