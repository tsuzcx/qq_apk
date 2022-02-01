package com.tencent.intervideo.nowproxy.customized_interface;

import android.os.Bundle;
import java.util.concurrent.Future;

public abstract interface CustomizedTicket
{
  public abstract Future<Bundle> getA1(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract Future<Bundle> getAccessToken(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.customized_interface.CustomizedTicket
 * JD-Core Version:    0.7.0.1
 */