package com.jeremyliao.liveeventbus.ipc.encode;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.jeremyliao.liveeventbus.ipc.DataType;
import com.jeremyliao.liveeventbus.ipc.json.JsonConverter;
import java.io.Serializable;

public class ValueEncoder
  implements IEncoder
{
  private final JsonConverter jsonConverter;
  
  public ValueEncoder(JsonConverter paramJsonConverter)
  {
    this.jsonConverter = paramJsonConverter;
  }
  
  public void encode(Intent paramIntent, Object paramObject)
  {
    if ((paramObject instanceof String))
    {
      paramIntent.putExtra("leb_ipc_value_type", DataType.STRING.ordinal());
      paramIntent.putExtra("leb_ipc_value", (String)paramObject);
      return;
    }
    if ((paramObject instanceof Integer))
    {
      paramIntent.putExtra("leb_ipc_value_type", DataType.INTEGER.ordinal());
      paramIntent.putExtra("leb_ipc_value", ((Integer)paramObject).intValue());
      return;
    }
    if ((paramObject instanceof Boolean))
    {
      paramIntent.putExtra("leb_ipc_value_type", DataType.BOOLEAN.ordinal());
      paramIntent.putExtra("leb_ipc_value", ((Boolean)paramObject).booleanValue());
      return;
    }
    if ((paramObject instanceof Long))
    {
      paramIntent.putExtra("leb_ipc_value_type", DataType.LONG.ordinal());
      paramIntent.putExtra("leb_ipc_value", ((Long)paramObject).longValue());
      return;
    }
    if ((paramObject instanceof Float))
    {
      paramIntent.putExtra("leb_ipc_value_type", DataType.FLOAT.ordinal());
      paramIntent.putExtra("leb_ipc_value", ((Float)paramObject).floatValue());
      return;
    }
    if ((paramObject instanceof Double))
    {
      paramIntent.putExtra("leb_ipc_value_type", DataType.DOUBLE.ordinal());
      paramIntent.putExtra("leb_ipc_value", ((Double)paramObject).doubleValue());
      return;
    }
    if ((paramObject instanceof Bundle))
    {
      paramIntent.putExtra("leb_ipc_value_type", DataType.BUNDLE.ordinal());
      paramIntent.putExtra("leb_ipc_value", (Bundle)paramObject);
      return;
    }
    if ((paramObject instanceof Parcelable))
    {
      paramIntent.putExtra("leb_ipc_value_type", DataType.PARCELABLE.ordinal());
      paramIntent.putExtra("leb_ipc_value", (Parcelable)paramObject);
      return;
    }
    if ((paramObject instanceof Serializable))
    {
      paramIntent.putExtra("leb_ipc_value_type", DataType.SERIALIZABLE.ordinal());
      paramIntent.putExtra("leb_ipc_value", (Serializable)paramObject);
      return;
    }
    try
    {
      String str = this.jsonConverter.toJson(paramObject);
      paramIntent.putExtra("leb_ipc_value_type", DataType.JSON.ordinal());
      paramIntent.putExtra("leb_ipc_value", str);
      paramIntent.putExtra("leb_ipc_class_name", paramObject.getClass().getCanonicalName());
      return;
    }
    catch (Exception paramIntent)
    {
      throw new EncodeException(paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.jeremyliao.liveeventbus.ipc.encode.ValueEncoder
 * JD-Core Version:    0.7.0.1
 */