package com.tencent.biz.pubaccount.readinjoy.logic;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.AppProtocolObserver;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xad6.oidb_cmd0xad6.ArticleExtInfo;
import tencent.im.oidb.cmd0xad6.oidb_cmd0xad6.RspBody;

class ReadInJoyAtlasManager$7
  extends ProtoUtils.AppProtocolObserver
{
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ReadInJoyAtlasManager.a, 2, "getAtlasCommentCount onResult, errorCode=" + paramInt);
    }
    if ((paramInt != -1) && (paramArrayOfByte != null)) {
      try
      {
        paramBundle = new oidb_cmd0xad6.RspBody();
        paramBundle.mergeFrom(paramArrayOfByte);
        if ((paramBundle.msg_ext_info.has()) && (((oidb_cmd0xad6.ArticleExtInfo)paramBundle.msg_ext_info.get()).uint64_comment.has()))
        {
          if (this.a != null) {
            this.a.a(true, ((oidb_cmd0xad6.ArticleExtInfo)paramBundle.msg_ext_info.get()).uint64_comment.get(), 0);
          }
        }
        else if (this.a != null)
        {
          this.a.a(false, 0L, -1);
          return;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        if (this.a != null) {
          this.a.a(false, 0L, -1);
        }
        QLog.e(ReadInJoyAtlasManager.a, 1, "getAtlasCommentCount onResult(), exception=" + paramArrayOfByte.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.logic.ReadInJoyAtlasManager.7
 * JD-Core Version:    0.7.0.1
 */