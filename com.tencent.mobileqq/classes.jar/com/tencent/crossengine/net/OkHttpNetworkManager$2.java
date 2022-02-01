package com.tencent.crossengine.net;

import okhttp3.Call;

class OkHttpNetworkManager$2
  implements NetworkManager.HttpRequest
{
  OkHttpNetworkManager$2(OkHttpNetworkManager paramOkHttpNetworkManager, Call paramCall, NetworkManager.Callback paramCallback) {}
  
  public void cancel()
  {
    this.jdField_a_of_type_Okhttp3Call.cancel();
    this.jdField_a_of_type_ComTencentCrossengineNetNetworkManager$Callback.onCancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.crossengine.net.OkHttpNetworkManager.2
 * JD-Core Version:    0.7.0.1
 */