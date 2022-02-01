package com.jeremyliao.liveeventbus.ipc.decode;

import android.content.Intent;
import com.jeremyliao.liveeventbus.ipc.json.JsonConverter;

public class ValueDecoder
  implements IDecoder
{
  private final JsonConverter jsonConverter;
  
  public ValueDecoder(JsonConverter paramJsonConverter)
  {
    this.jsonConverter = paramJsonConverter;
  }
  
  public Object decode(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("leb_ipc_value_type", -1);
    if (i < 0) {
      throw new DecodeException("Index Error");
    }
    Object localObject = com.jeremyliao.liveeventbus.ipc.DataType.values()[i];
    switch (ValueDecoder.1.$SwitchMap$com$jeremyliao$liveeventbus$ipc$DataType[localObject.ordinal()])
    {
    default: 
      throw new DecodeException();
    case 1: 
      return paramIntent.getStringExtra("leb_ipc_value");
    case 2: 
      return Integer.valueOf(paramIntent.getIntExtra("leb_ipc_value", -1));
    case 3: 
      return Boolean.valueOf(paramIntent.getBooleanExtra("leb_ipc_value", false));
    case 4: 
      return Long.valueOf(paramIntent.getLongExtra("leb_ipc_value", -1L));
    case 5: 
      return Float.valueOf(paramIntent.getFloatExtra("leb_ipc_value", -1.0F));
    case 6: 
      return Double.valueOf(paramIntent.getDoubleExtra("leb_ipc_value", -1.0D));
    case 7: 
      return paramIntent.getParcelableExtra("leb_ipc_value");
    case 8: 
      return paramIntent.getSerializableExtra("leb_ipc_value");
    case 9: 
      return paramIntent.getBundleExtra("leb_ipc_value");
    }
    try
    {
      String str2 = paramIntent.getStringExtra("leb_ipc_value");
      str3 = paramIntent.getStringExtra("leb_ipc_class_name");
      paramIntent = null;
      try
      {
        localObject = Class.forName(str3);
        paramIntent = (Intent)localObject;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        for (;;)
        {
          i = str3.lastIndexOf('.');
          if (i != -1)
          {
            paramIntent = str3.substring(0, i);
            String str1 = str3.substring(i + 1);
            paramIntent = Class.forName(paramIntent + "$" + str1);
          }
        }
      }
      return this.jsonConverter.fromJson(str2, paramIntent);
    }
    catch (Exception paramIntent)
    {
      String str3;
      throw new DecodeException(paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.jeremyliao.liveeventbus.ipc.decode.ValueDecoder
 * JD-Core Version:    0.7.0.1
 */