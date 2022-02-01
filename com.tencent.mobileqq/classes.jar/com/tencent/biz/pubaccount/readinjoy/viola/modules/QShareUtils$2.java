package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import android.graphics.BitmapFactory;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import java.io.IOException;
import java.util.Map;
import txn;

public class QShareUtils$2
  implements Runnable
{
  public QShareUtils$2(txn paramtxn, String paramString, Map paramMap, AppInterface paramAppInterface, Runnable paramRunnable) {}
  
  public void run()
  {
    try
    {
      Object localObject = HttpUtil.openUrlForByte(BaseApplicationImpl.getContext(), MsfSdkUtils.insertMtype("GameCenter", this.jdField_a_of_type_JavaLangString), "GET", null, null);
      if (localObject != null)
      {
        localObject = BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length);
        if (localObject != null) {
          this.jdField_a_of_type_JavaUtilMap.put("image", localObject);
        }
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      break label49;
    }
    catch (IOException localIOException)
    {
      label49:
      break label49;
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.runOnUiThread(this.jdField_a_of_type_JavaLangRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.QShareUtils.2
 * JD-Core Version:    0.7.0.1
 */