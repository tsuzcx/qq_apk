package com.tencent.intervideo.nowproxy.customized_interface;

import android.os.Bundle;
import com.tencent.qqinterface.CommonCallback;

public abstract interface CustomCgi
{
  public abstract void doCgiReq(Bundle paramBundle, CommonCallback<Bundle> paramCommonCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.customized_interface.CustomCgi
 * JD-Core Version:    0.7.0.1
 */