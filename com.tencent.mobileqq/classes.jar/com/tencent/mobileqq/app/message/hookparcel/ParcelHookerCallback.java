package com.tencent.mobileqq.app.message.hookparcel;

import com.google.gson.GsonBuilder;
import com.tencent.mobileqq.app.message.RecordForTest;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import java.lang.reflect.Field;

public class ParcelHookerCallback
  implements ParcelHooker.Callback
{
  public void a(GsonBuilder paramGsonBuilder, Field[] paramArrayOfField)
  {
    int j = paramArrayOfField.length;
    int i = 0;
    while (i < j)
    {
      Field localField = paramArrayOfField[i];
      if (((localField.getModifiers() & 0xC8) == 0) && (localField.getAnnotation(RecordForTest.class) != null)) {
        if (MessageMicro.class.isAssignableFrom(localField.getType())) {
          paramGsonBuilder.registerTypeAdapter(localField.getType(), new PBJsonAdapter(localField.getType()));
        } else if (StructMsgForGeneralShare.class == localField.getType()) {
          paramGsonBuilder.registerTypeAdapter(localField.getType(), new GeneralStructMsgJsonAdapter());
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.hookparcel.ParcelHookerCallback
 * JD-Core Version:    0.7.0.1
 */