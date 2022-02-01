package com.huawei.hms.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.ArrayList;

public class SafeIntent
  extends Intent
{
  public SafeIntent(Intent paramIntent)
  {
    super(localIntent);
  }
  
  public String getAction()
  {
    try
    {
      String str = super.getAction();
      return str;
    }
    catch (Exception localException)
    {
      label7:
      break label7;
    }
    return "";
  }
  
  public boolean[] getBooleanArrayExtra(String paramString)
  {
    try
    {
      paramString = super.getBooleanArrayExtra(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      label8:
      break label8;
    }
    return new boolean[0];
  }
  
  public boolean getBooleanExtra(String paramString, boolean paramBoolean)
  {
    try
    {
      boolean bool = super.getBooleanExtra(paramString, paramBoolean);
      return bool;
    }
    catch (Exception paramString) {}
    return paramBoolean;
  }
  
  public Bundle getBundleExtra(String paramString)
  {
    try
    {
      paramString = super.getBundleExtra(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      label8:
      break label8;
    }
    return new Bundle();
  }
  
  public byte[] getByteArrayExtra(String paramString)
  {
    try
    {
      paramString = super.getByteArrayExtra(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      label8:
      break label8;
    }
    return new byte[0];
  }
  
  public byte getByteExtra(String paramString, byte paramByte)
  {
    try
    {
      byte b = super.getByteExtra(paramString, paramByte);
      return b;
    }
    catch (Exception paramString) {}
    return paramByte;
  }
  
  public char[] getCharArrayExtra(String paramString)
  {
    try
    {
      paramString = super.getCharArrayExtra(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      label8:
      break label8;
    }
    return new char[0];
  }
  
  public char getCharExtra(String paramString, char paramChar)
  {
    try
    {
      char c = super.getCharExtra(paramString, paramChar);
      return c;
    }
    catch (Exception paramString) {}
    return paramChar;
  }
  
  public CharSequence[] getCharSequenceArrayExtra(String paramString)
  {
    try
    {
      paramString = super.getCharSequenceArrayExtra(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      label8:
      break label8;
    }
    return new CharSequence[0];
  }
  
  public ArrayList<CharSequence> getCharSequenceArrayListExtra(String paramString)
  {
    try
    {
      paramString = super.getCharSequenceArrayListExtra(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      label8:
      break label8;
    }
    return new ArrayList();
  }
  
  public CharSequence getCharSequenceExtra(String paramString)
  {
    try
    {
      paramString = super.getCharSequenceExtra(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      label8:
      break label8;
    }
    return "";
  }
  
  public double[] getDoubleArrayExtra(String paramString)
  {
    try
    {
      paramString = super.getDoubleArrayExtra(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      label8:
      break label8;
    }
    return new double[0];
  }
  
  public double getDoubleExtra(String paramString, double paramDouble)
  {
    try
    {
      double d = super.getDoubleExtra(paramString, paramDouble);
      return d;
    }
    catch (Exception paramString) {}
    return paramDouble;
  }
  
  public Bundle getExtras()
  {
    try
    {
      Bundle localBundle = super.getExtras();
      return localBundle;
    }
    catch (Exception localException)
    {
      label7:
      break label7;
    }
    return new Bundle();
  }
  
  public float[] getFloatArrayExtra(String paramString)
  {
    try
    {
      paramString = super.getFloatArrayExtra(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      label8:
      break label8;
    }
    return new float[0];
  }
  
  public float getFloatExtra(String paramString, float paramFloat)
  {
    try
    {
      float f = super.getFloatExtra(paramString, paramFloat);
      return f;
    }
    catch (Exception paramString) {}
    return paramFloat;
  }
  
  public int[] getIntArrayExtra(String paramString)
  {
    try
    {
      paramString = super.getIntArrayExtra(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      label8:
      break label8;
    }
    return new int[0];
  }
  
  public int getIntExtra(String paramString, int paramInt)
  {
    try
    {
      int i = super.getIntExtra(paramString, paramInt);
      return i;
    }
    catch (Exception paramString) {}
    return paramInt;
  }
  
  public ArrayList<Integer> getIntegerArrayListExtra(String paramString)
  {
    try
    {
      paramString = super.getIntegerArrayListExtra(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      label8:
      break label8;
    }
    return new ArrayList();
  }
  
  public long[] getLongArrayExtra(String paramString)
  {
    try
    {
      paramString = super.getLongArrayExtra(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      label8:
      break label8;
    }
    return new long[0];
  }
  
  public long getLongExtra(String paramString, long paramLong)
  {
    try
    {
      long l = super.getLongExtra(paramString, paramLong);
      return l;
    }
    catch (Exception paramString) {}
    return paramLong;
  }
  
  public Parcelable[] getParcelableArrayExtra(String paramString)
  {
    try
    {
      paramString = super.getParcelableArrayExtra(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      label8:
      break label8;
    }
    return new Parcelable[0];
  }
  
  public <T extends Parcelable> ArrayList<T> getParcelableArrayListExtra(String paramString)
  {
    try
    {
      paramString = super.getParcelableArrayListExtra(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      label8:
      break label8;
    }
    return null;
  }
  
  public <T extends Parcelable> T getParcelableExtra(String paramString)
  {
    try
    {
      paramString = super.getParcelableExtra(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      label8:
      break label8;
    }
    return null;
  }
  
  public Serializable getSerializableExtra(String paramString)
  {
    try
    {
      paramString = super.getSerializableExtra(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      label8:
      break label8;
    }
    return null;
  }
  
  public short[] getShortArrayExtra(String paramString)
  {
    try
    {
      paramString = super.getShortArrayExtra(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      label8:
      break label8;
    }
    return new short[0];
  }
  
  public short getShortExtra(String paramString, short paramShort)
  {
    try
    {
      short s = super.getShortExtra(paramString, paramShort);
      return s;
    }
    catch (Exception paramString) {}
    return paramShort;
  }
  
  public String[] getStringArrayExtra(String paramString)
  {
    try
    {
      paramString = super.getStringArrayExtra(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      label8:
      break label8;
    }
    return new String[0];
  }
  
  public ArrayList<String> getStringArrayListExtra(String paramString)
  {
    try
    {
      paramString = super.getStringArrayListExtra(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      label8:
      break label8;
    }
    return new ArrayList();
  }
  
  public String getStringExtra(String paramString)
  {
    try
    {
      paramString = super.getStringExtra(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      label8:
      break label8;
    }
    return "";
  }
  
  public boolean hasExtra(String paramString)
  {
    try
    {
      boolean bool = super.hasExtra(paramString);
      return bool;
    }
    catch (Exception paramString)
    {
      label8:
      break label8;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.ui.SafeIntent
 * JD-Core Version:    0.7.0.1
 */