package com.android.dx.cf.iface;

import com.android.dx.util.ByteArray;

public abstract interface ParseObserver
{
  public abstract void changeIndent(int paramInt);
  
  public abstract void endParsingMember(ByteArray paramByteArray, int paramInt, String paramString1, String paramString2, Member paramMember);
  
  public abstract void parsed(ByteArray paramByteArray, int paramInt1, int paramInt2, String paramString);
  
  public abstract void startParsingMember(ByteArray paramByteArray, int paramInt, String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.iface.ParseObserver
 * JD-Core Version:    0.7.0.1
 */