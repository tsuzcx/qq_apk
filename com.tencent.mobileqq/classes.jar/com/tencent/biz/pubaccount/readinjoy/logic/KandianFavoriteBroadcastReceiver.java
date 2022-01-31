package com.tencent.biz.pubaccount.readinjoy.logic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import ons;
import tencent.im.oidb.FavoriteCKVData.KandianFavoriteBizData;

public class KandianFavoriteBroadcastReceiver
  extends BroadcastReceiver
{
  public static final String a;
  private ons a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "Q.readinjoy.atlas.." + KandianFavoriteBroadcastReceiver.class.getSimpleName();
  }
  
  public KandianFavoriteBroadcastReceiver(ons paramons)
  {
    this.jdField_a_of_type_Ons = paramons;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    for (;;)
    {
      return;
      paramIntent = paramIntent.getExtras();
      paramContext = paramIntent.getString("cid");
      int i = paramIntent.getInt("operation");
      boolean bool = paramIntent.getBoolean("isSuccess");
      paramIntent = (ArrayList)paramIntent.get("bizData");
      if ((paramIntent != null) && (paramIntent.size() > 0))
      {
        FavoriteCKVData.KandianFavoriteBizData localKandianFavoriteBizData = new FavoriteCKVData.KandianFavoriteBizData();
        try
        {
          localKandianFavoriteBizData.mergeFrom((byte[])paramIntent.get(0));
          paramIntent = localKandianFavoriteBizData.bytes_rowkey.get().toStringUtf8();
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "BroadcastReceiver.onReceive  operation == " + i + " rowkey=" + paramIntent + " cid=" + paramContext);
          }
          if (this.jdField_a_of_type_Ons != null)
          {
            this.jdField_a_of_type_Ons.a(bool, paramIntent, i, paramContext);
            return;
          }
        }
        catch (InvalidProtocolBufferMicroException paramContext)
        {
          paramContext.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.logic.KandianFavoriteBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */