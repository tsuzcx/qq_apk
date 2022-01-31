package com.tencent.biz.pubaccount.readinjoy.engine;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import bjxj;
import com.tencent.biz.pubaccount.readinjoy.struct.MySelfNormalItemRedPointInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

class KandianMergeManager$35
  implements Runnable
{
  KandianMergeManager$35(KandianMergeManager paramKandianMergeManager, MySelfNormalItemRedPointInfo paramMySelfNormalItemRedPointInfo) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = bjxj.a(KandianMergeManager.a(this.this$0), true, false).edit();
    Object localObject = new ByteArrayOutputStream();
    try
    {
      new ObjectOutputStream((OutputStream)localObject).writeObject(this.a);
      localObject = new String(Base64.encode(((ByteArrayOutputStream)localObject).toByteArray(), 0));
      localEditor.putString("kandian_myself_red_point" + this.a.itemId, (String)localObject);
      bjxj.a(localEditor, true);
      return;
    }
    catch (IOException localIOException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("KandianMergeManager", 2, "writeToSpMySelfRedPointInfo:" + localIOException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.35
 * JD-Core Version:    0.7.0.1
 */