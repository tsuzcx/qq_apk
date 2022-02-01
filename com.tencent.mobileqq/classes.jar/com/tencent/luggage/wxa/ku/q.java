package com.tencent.luggage.wxa.ku;

import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.jx.c;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

public final class q
  extends a
{
  private static final int CTRL_INDEX = 115;
  private static final String NAME = "getSavedFileList";
  
  public void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    b.a.execute(new q.1(this, paramc, paramInt));
  }
  
  protected boolean b()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ku.q
 * JD-Core Version:    0.7.0.1
 */