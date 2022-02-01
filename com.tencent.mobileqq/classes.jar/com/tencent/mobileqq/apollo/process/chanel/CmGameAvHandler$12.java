package com.tencent.mobileqq.apollo.process.chanel;

import alvx;
import alwt;
import alwv;
import alym;
import amgw;
import android.text.TextUtils;
import com.tencent.TMG.sdk.AVContext;
import com.tencent.TMG.sdk.AVRoomMulti;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.ArrayList;
import org.json.JSONArray;

public class CmGameAvHandler$12
  implements Runnable
{
  public CmGameAvHandler$12(alwt paramalwt, JSONArray paramJSONArray) {}
  
  public void run()
  {
    if (this.a.length() <= 0)
    {
      alwt.a(this.this$0).clear();
      amgw.a(BaseApplicationImpl.getContext()).a().getRoom().cancelAllView(new alwv(this));
    }
    for (;;)
    {
      return;
      alwt.a(this.this$0).clear();
      String[] arrayOfString = new String[this.a.length()];
      String str3 = alvx.a().getCurrentAccountUin();
      int i = 0;
      while (i < this.a.length())
      {
        try
        {
          alym localalym = alvx.a(alwt.a(this.this$0));
          if (localalym != null)
          {
            String str2 = localalym.c(this.a.get(i).toString());
            String str1 = str2;
            if (TextUtils.isEmpty(str2)) {
              str1 = localalym.a(this.a.get(i).toString());
            }
            arrayOfString[i] = str1;
            alwt.a(this.this$0).add(str1);
            alwt.a(this.this$0, arrayOfString, str3);
          }
        }
        catch (Exception localException)
        {
          label175:
          break label175;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.12
 * JD-Core Version:    0.7.0.1
 */