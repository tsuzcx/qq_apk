package com.tencent.mobileqq.app.utils;

import android.util.Log;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;

public class PokeBigResHandler$NetEngine
  implements INetEngine.INetEngineListener
{
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    Log.e("Ron", "req:[" + paramNetReq.toString() + "\n curOffset" + paramLong1 + "\n totalLen" + paramLong2 + "]");
  }
  
  public void a(NetResp paramNetResp)
  {
    if (paramNetResp.jdField_a_of_type_Int == 0) {
      PokeBigResHandler.a = PokeBigResHandler.b(paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.c);
    }
    PokeBigResHandler.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.PokeBigResHandler.NetEngine
 * JD-Core Version:    0.7.0.1
 */