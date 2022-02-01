package com.tencent.mobileqq.activity.aio.stickerrecommended.impl;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.stickerrecommended.BloomFilter;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

class StickerRecManagerImpl$7
  implements INetEngineListener
{
  StickerRecManagerImpl$7(StickerRecManagerImpl paramStickerRecManagerImpl, String paramString1, boolean paramBoolean, String paramString2) {}
  
  public void onResp(NetResp paramNetResp)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onResp resultcode: ");
      ((StringBuilder)localObject).append(paramNetResp.mHttpCode);
      ((StringBuilder)localObject).append(" threadid=");
      ((StringBuilder)localObject).append(Thread.currentThread().getId());
      QLog.i("StickerRecManager", 2, ((StringBuilder)localObject).toString());
    }
    if (paramNetResp.mHttpCode == 200)
    {
      paramNetResp = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedImplStickerRecManagerImpl;
      if (StickerRecManagerImpl.access$600(paramNetResp, StickerRecManagerImpl.access$400(paramNetResp), StickerRecManagerImpl.access$500(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedImplStickerRecManagerImpl), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean)) {
        if (StickerRecManagerImpl.access$500(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedImplStickerRecManagerImpl).exists())
        {
          if (QLog.isColorLevel()) {
            QLog.d("StickerRecManager", 2, "pull words success");
          }
          l1 = 0L;
        }
      }
    }
    try
    {
      l2 = SystemClock.elapsedRealtime();
      l1 = l2;
      localObject = new JSONObject(FileUtils.readFileToString(StickerRecManagerImpl.access$500(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedImplStickerRecManagerImpl)));
      l1 = l2;
      paramNetResp = ((JSONObject)localObject).optString("version", null);
      l1 = l2;
      localObject = ((JSONObject)localObject).optJSONArray("words");
      l1 = l2;
      localBloomFilter = new BloomFilter();
      l1 = l2;
      localBloomFilter.version = paramNetResp;
      i = 0;
    }
    catch (Exception paramNetResp)
    {
      for (;;)
      {
        long l2;
        BloomFilter localBloomFilter;
        int i;
        continue;
        i += 1;
      }
    }
    long l1 = l2;
    if (i < ((JSONArray)localObject).length())
    {
      l1 = l2;
      paramNetResp = ((JSONArray)localObject).optString(i);
      l1 = l2;
      if (!TextUtils.isEmpty(paramNetResp))
      {
        l1 = l2;
        localBloomFilter.add(paramNetResp);
      }
    }
    else
    {
      l1 = l2;
      FileUtils.deleteFile(StickerRecManagerImpl.access$700(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedImplStickerRecManagerImpl).getAbsolutePath());
      l1 = l2;
      StickerRecManagerImpl.access$800(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedImplStickerRecManagerImpl, StickerRecManagerImpl.access$700(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedImplStickerRecManagerImpl).getAbsolutePath(), localBloomFilter);
      l1 = l2;
      FileUtils.deleteFile(StickerRecManagerImpl.access$500(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedImplStickerRecManagerImpl).getAbsolutePath());
      l1 = l2;
      StickerRecManagerImpl.updateStickerRecVersion(StickerRecManagerImpl.access$300(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedImplStickerRecManagerImpl).getApp(), "words_version_key805_gray_one", StickerRecManagerImpl.access$300(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedImplStickerRecManagerImpl).getCurrentUin(), this.b);
      l1 = l2;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedImplStickerRecManagerImpl.unInit();
      l1 = l2;
      if (QLog.isColorLevel())
      {
        l1 = l2;
        paramNetResp = new StringBuilder();
        l1 = l2;
        paramNetResp.append("generate encode table time cost : ");
        l1 = l2;
        paramNetResp.append(SystemClock.elapsedRealtime() - l2);
        l1 = l2;
        QLog.d("StickerRecManager", 2, paramNetResp.toString());
        return;
        if (QLog.isColorLevel())
        {
          paramNetResp = new StringBuilder();
          paramNetResp.append("generate encode table time error cost : ");
          paramNetResp.append(SystemClock.elapsedRealtime() - l1);
          QLog.d("StickerRecManager", 2, paramNetResp.toString());
          QLog.d("StickerRecManager", 2, "build EncodeTable error !");
          return;
          if (QLog.isColorLevel()) {
            QLog.d("StickerRecManager", 2, "updateWords fail: words file is not exist.");
          }
        }
      }
      return;
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.impl.StickerRecManagerImpl.7
 * JD-Core Version:    0.7.0.1
 */