package com.tencent.mobileqq.apollo.process.chanel;

import ampj;
import amqf;
import amqh;
import amry;
import anai;
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
  public CmGameAvHandler$12(amqf paramamqf, JSONArray paramJSONArray) {}
  
  public void run()
  {
    if (this.a.length() <= 0)
    {
      amqf.a(this.this$0).clear();
      anai.a(BaseApplicationImpl.getContext()).a().getRoom().cancelAllView(new amqh(this));
    }
    for (;;)
    {
      return;
      amqf.a(this.this$0).clear();
      String[] arrayOfString = new String[this.a.length()];
      String str3 = ampj.a().getCurrentAccountUin();
      int i = 0;
      while (i < this.a.length())
      {
        try
        {
          amry localamry = ampj.a(amqf.a(this.this$0));
          if (localamry != null)
          {
            String str2 = localamry.c(this.a.get(i).toString());
            String str1 = str2;
            if (TextUtils.isEmpty(str2)) {
              str1 = localamry.a(this.a.get(i).toString());
            }
            arrayOfString[i] = str1;
            amqf.a(this.this$0).add(str1);
            amqf.a(this.this$0, arrayOfString, str3);
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