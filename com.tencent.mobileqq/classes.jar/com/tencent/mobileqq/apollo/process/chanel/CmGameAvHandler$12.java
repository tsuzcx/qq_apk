package com.tencent.mobileqq.apollo.process.chanel;

import anbd;
import anbz;
import ancb;
import android.text.TextUtils;
import ands;
import anmc;
import com.tencent.TMG.sdk.AVContext;
import com.tencent.TMG.sdk.AVRoomMulti;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.ArrayList;
import org.json.JSONArray;

public class CmGameAvHandler$12
  implements Runnable
{
  public CmGameAvHandler$12(anbz paramanbz, JSONArray paramJSONArray) {}
  
  public void run()
  {
    if (this.a.length() <= 0)
    {
      anbz.a(this.this$0).clear();
      anmc.a(BaseApplicationImpl.getContext()).a().getRoom().cancelAllView(new ancb(this));
    }
    for (;;)
    {
      return;
      anbz.a(this.this$0).clear();
      String[] arrayOfString = new String[this.a.length()];
      String str3 = anbd.a().getCurrentAccountUin();
      int i = 0;
      while (i < this.a.length())
      {
        try
        {
          ands localands = anbd.a(anbz.a(this.this$0));
          if (localands != null)
          {
            String str2 = localands.c(this.a.get(i).toString());
            String str1 = str2;
            if (TextUtils.isEmpty(str2)) {
              str1 = localands.a(this.a.get(i).toString());
            }
            arrayOfString[i] = str1;
            anbz.a(this.this$0).add(str1);
            anbz.a(this.this$0, arrayOfString, str3);
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