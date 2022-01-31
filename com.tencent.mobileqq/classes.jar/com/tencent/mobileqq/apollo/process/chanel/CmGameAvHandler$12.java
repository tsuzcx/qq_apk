package com.tencent.mobileqq.apollo.process.chanel;

import akwd;
import akxb;
import akxd;
import akyu;
import alhb;
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
  public CmGameAvHandler$12(akxb paramakxb, JSONArray paramJSONArray) {}
  
  public void run()
  {
    if (this.a.length() <= 0)
    {
      akxb.a(this.this$0).clear();
      alhb.a(BaseApplicationImpl.getContext()).a().getRoom().cancelAllView(new akxd(this));
    }
    for (;;)
    {
      return;
      akxb.a(this.this$0).clear();
      String[] arrayOfString = new String[this.a.length()];
      String str3 = akwd.a().getCurrentAccountUin();
      int i = 0;
      while (i < this.a.length())
      {
        try
        {
          akyu localakyu = akwd.a(akxb.a(this.this$0));
          if (localakyu != null)
          {
            String str2 = localakyu.c(this.a.get(i).toString());
            String str1 = str2;
            if (TextUtils.isEmpty(str2)) {
              str1 = localakyu.a(this.a.get(i).toString());
            }
            arrayOfString[i] = str1;
            akxb.a(this.this$0).add(str1);
            akxb.a(this.this$0, arrayOfString, str3);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.12
 * JD-Core Version:    0.7.0.1
 */