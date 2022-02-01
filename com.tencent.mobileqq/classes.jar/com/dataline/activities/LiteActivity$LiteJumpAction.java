package com.dataline.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class LiteActivity$LiteJumpAction
{
  LiteActivity a;
  ArrayList<String> b;
  int c;
  
  public LiteActivity$LiteJumpAction(LiteActivity paramLiteActivity1, LiteActivity paramLiteActivity2)
  {
    this.a = paramLiteActivity2;
  }
  
  String a(Uri paramUri)
  {
    return FileProvider7Helper.getRealPathFromContentURI(this.d.getApplicationContext(), paramUri);
  }
  
  public void a()
  {
    if (this.b == null) {
      return;
    }
    if (this.c == -1) {
      return;
    }
    if (QLog.isColorLevel())
    {
      Object localObject1 = LiteActivity.a;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("sendMultipleFileWithFileProvider. [fileType] = ");
      ((StringBuilder)localObject2).append(this.c);
      QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      localObject1 = this.b.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        String str = LiteActivity.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[filePath] = ");
        localStringBuilder.append((String)localObject2);
        QLog.i(str, 1, localStringBuilder.toString());
      }
    }
    this.d.a(this.b, this.c);
    this.b = null;
    this.c = -1;
  }
  
  public void a(Intent paramIntent)
  {
    try
    {
      Object localObject2 = paramIntent.getExtras();
      if (paramIntent.getBooleanExtra("dataline_share_finish", false)) {
        return;
      }
      paramIntent.putExtra("dataline_share_finish", true);
      Object localObject1 = paramIntent.getType();
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        return;
      }
      if (localObject2 == null)
      {
        localObject2 = LiteActivity.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("LiteJumpAction:doShare type is [");
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append("], action is [");
        localStringBuilder.append(paramIntent.getAction());
        localStringBuilder.append("]");
        QLog.e((String)localObject2, 1, localStringBuilder.toString());
        return;
      }
      boolean bool = ((String)localObject1).startsWith("text");
      if ((bool) && (!((Bundle)localObject2).containsKey("android.intent.extra.STREAM")))
      {
        paramIntent = ((Bundle)localObject2).getString("android.intent.extra.TEXT");
        this.a.a(paramIntent);
        return;
      }
      if (((String)localObject1).startsWith("message"))
      {
        paramIntent = (SpannableString)((Bundle)localObject2).get("android.intent.extra.TEXT");
        this.a.a(paramIntent.toString());
        return;
      }
      bool = ((String)localObject1).startsWith("image");
      if (bool)
      {
        if (paramIntent.getAction().equals("android.intent.action.SEND"))
        {
          paramIntent = (Uri)((Bundle)localObject2).get("android.intent.extra.STREAM");
          if (paramIntent == null)
          {
            LiteActivity.a(this.d);
            return;
          }
          localObject1 = new ArrayList();
          ((ArrayList)localObject1).add(paramIntent);
          a((ArrayList)localObject1, true);
          return;
        }
        paramIntent = (ArrayList)((Bundle)localObject2).get("android.intent.extra.STREAM");
        if (paramIntent.size() > 50)
        {
          LiteActivity.b(this.d);
          return;
        }
        a(paramIntent, true);
        return;
      }
      if (paramIntent.getAction().equals("android.intent.action.SEND"))
      {
        paramIntent = (Uri)((Bundle)localObject2).get("android.intent.extra.STREAM");
        if (paramIntent == null)
        {
          LiteActivity.a(this.d);
          return;
        }
        if (((paramIntent instanceof Uri)) && ("text/x-vcard".equals(localObject1)) && ("content".equals(paramIntent.getScheme())))
        {
          new LiteActivity.ShareTask(this.d).execute(new Object[] { this.d.getApplicationContext(), paramIntent });
          return;
        }
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).add(paramIntent);
        a((ArrayList)localObject1, false);
        return;
      }
      a((ArrayList)((Bundle)localObject2).get("android.intent.extra.STREAM"), false);
      return;
    }
    catch (Exception paramIntent)
    {
      paramIntent.printStackTrace();
    }
  }
  
  void a(ArrayList<Uri> paramArrayList, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.LiteJumpAction
 * JD-Core Version:    0.7.0.1
 */