package com.tencent.mobileqq.apollo.process.chanel;

import android.text.TextUtils;
import com.tencent.TMG.sdk.AVContext;
import com.tencent.TMG.sdk.AVRoomMulti;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.data.CmGameOpenIdFinder;
import com.tencent.mobileqq.apollo.tmg_opensdk.AVManager;
import java.util.ArrayList;
import org.json.JSONArray;

class CmGameAvHandler$12
  implements Runnable
{
  CmGameAvHandler$12(CmGameAvHandler paramCmGameAvHandler, JSONArray paramJSONArray) {}
  
  public void run()
  {
    if (this.a.length() <= 0)
    {
      CmGameAvHandler.a(this.this$0).clear();
      AVManager.a(BaseApplicationImpl.getContext()).a().getRoom().cancelAllView(new CmGameAvHandler.12.1(this));
    }
    for (;;)
    {
      return;
      CmGameAvHandler.a(this.this$0).clear();
      String[] arrayOfString = new String[this.a.length()];
      String str3 = CmGameUtil.a().getCurrentAccountUin();
      int i = 0;
      while (i < this.a.length())
      {
        try
        {
          CmGameOpenIdFinder localCmGameOpenIdFinder = CmGameUtil.a(CmGameAvHandler.a(this.this$0));
          if (localCmGameOpenIdFinder != null)
          {
            String str2 = localCmGameOpenIdFinder.c(this.a.get(i).toString());
            String str1 = str2;
            if (TextUtils.isEmpty(str2)) {
              str1 = localCmGameOpenIdFinder.a(this.a.get(i).toString());
            }
            arrayOfString[i] = str1;
            CmGameAvHandler.a(this.this$0).add(str1);
            CmGameAvHandler.a(this.this$0, arrayOfString, str3);
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