package com.tencent.avgame.gameresult;

import android.annotation.SuppressLint;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.CommFileExtReq;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class GameResultUploadMgrForRemote
{
  private volatile WeakReference<BaseQQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private ConcurrentHashMap<String, GameResultUploadMgrForRemote.UploadInfo> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public GameResultUploadMgrForRemote(BaseQQAppInterface paramBaseQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseQQAppInterface);
  }
  
  private BaseQQAppInterface a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      synchronized (this.jdField_a_of_type_JavaLangRefWeakReference)
      {
        BaseQQAppInterface localBaseQQAppInterface = (BaseQQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        return localBaseQQAppInterface;
      }
    }
    return null;
  }
  
  @SuppressLint({"HandlerLeak"})
  private TransProcessorHandler a()
  {
    return new GameResultUploadMgrForRemote.1(this, ThreadManagerV2.getFileThreadLooper());
  }
  
  private String a(BaseQQAppInterface paramBaseQQAppInterface, String paramString1, int paramInt, String paramString2)
  {
    ITransFileController localITransFileController = (ITransFileController)paramBaseQQAppInterface.getRuntimeService(ITransFileController.class);
    Object localObject = a();
    localITransFileController.addHandle((TransProcessorHandler)localObject);
    ((TransProcessorHandler)localObject).addFilter(new Class[] { BDHCommonUploadProcessor.class });
    localObject = new TransferRequest();
    ((TransferRequest)localObject).mIsUp = true;
    ((TransferRequest)localObject).mCommandId = 78;
    ((TransferRequest)localObject).mLocalPath = paramString2;
    ((TransferRequest)localObject).mUniseq = ((Math.random() * 1000000.0D));
    paramString2 = new StringBuilder();
    paramString2.append("");
    paramString2.append(paramInt);
    ((TransferRequest)localObject).mPeerUin = paramString2.toString();
    ((TransferRequest)localObject).mSelfUin = paramBaseQQAppInterface.getCurrentUin();
    ((TransferRequest)localObject).mFileType = 24;
    ((TransferRequest)localObject).extraObject = paramString1;
    paramBaseQQAppInterface = new Bdh_extinfo.CommFileExtReq();
    paramBaseQQAppInterface.uint32_action_type.set(0);
    paramBaseQQAppInterface.bytes_uuid.set(ByteStringMicro.copyFromUtf8(UUID.randomUUID().toString()));
    ((TransferRequest)localObject).mExtentionInfo = paramBaseQQAppInterface.toByteArray();
    localITransFileController.transferAsync((TransferRequest)localObject);
    return paramString1;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      synchronized (this.jdField_a_of_type_JavaLangRefWeakReference)
      {
        this.jdField_a_of_type_JavaLangRefWeakReference.clear();
        return;
      }
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(" is not in RequestMap");
        QLog.w("GameResultUploadMgrForRemote_GameRC", 1, localStringBuilder.toString());
        return;
      }
      ThreadManagerV2.excute(new GameResultUploadMgrForRemote.3(this, (GameResultUploadMgrForRemote.UploadInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString), paramString), 16, null, false);
      return;
    }
    finally {}
  }
  
  /* Error */
  public void a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 108	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   9: astore_3
    //   10: aload_3
    //   11: aload_1
    //   12: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: pop
    //   16: aload_3
    //   17: ldc 220
    //   19: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: ldc 197
    //   25: iconst_1
    //   26: aload_3
    //   27: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 223	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: aload_0
    //   34: getfield 19	com/tencent/avgame/gameresult/GameResultUploadMgrForRemote:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   37: astore_3
    //   38: aload_3
    //   39: monitorenter
    //   40: aload_0
    //   41: getfield 19	com/tencent/avgame/gameresult/GameResultUploadMgrForRemote:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   44: aload_1
    //   45: invokevirtual 193	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   48: ifne +8 -> 56
    //   51: aload_3
    //   52: monitorexit
    //   53: aload_0
    //   54: monitorexit
    //   55: return
    //   56: aload_0
    //   57: getfield 19	com/tencent/avgame/gameresult/GameResultUploadMgrForRemote:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   60: aload_1
    //   61: invokevirtual 226	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   64: pop
    //   65: aload_3
    //   66: monitorexit
    //   67: aload_0
    //   68: monitorexit
    //   69: return
    //   70: astore_1
    //   71: aload_3
    //   72: monitorexit
    //   73: aload_1
    //   74: athrow
    //   75: astore_1
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_1
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	GameResultUploadMgrForRemote
    //   0	80	1	paramString	String
    //   0	80	2	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   40	53	70	finally
    //   56	67	70	finally
    //   71	73	70	finally
    //   2	40	75	finally
    //   73	75	75	finally
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    try
    {
      boolean bool = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1);
      if (!bool) {
        return;
      }
      GameResultUploadMgrForRemote.UploadInfo localUploadInfo = (GameResultUploadMgrForRemote.UploadInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
      localUploadInfo.jdField_a_of_type_ComTencentAvgameGameresultGameResultUploadMgrForRemote$GameResultUploadCallback.a(paramString1, paramInt, paramString2);
      if (paramInt == 0)
      {
        localUploadInfo.jdField_a_of_type_Boolean = false;
      }
      else if (paramInt == 1)
      {
        localUploadInfo.jdField_b_of_type_Boolean = false;
        if (localUploadInfo.c) {
          b(paramString1);
        }
      }
      return;
    }
    finally {}
  }
  
  public boolean a(BaseQQAppInterface paramBaseQQAppInterface, String paramString1, String paramString2, String paramString3, GameResultUploadMgrForRemote.GameResultUploadCallback paramGameResultUploadCallback)
  {
    try
    {
      if (QLog.isDebugVersion())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("recv avgame upload request playId:");
        ((StringBuilder)localObject).append(paramString1);
        QLog.i("GameResultUploadMgrForRemote_GameRC", 1, ((StringBuilder)localObject).toString());
      }
      Object localObject = new GameResultUploadMgrForRemote.UploadInfo(this, null);
      ((GameResultUploadMgrForRemote.UploadInfo)localObject).jdField_a_of_type_JavaLangString = paramString2;
      ((GameResultUploadMgrForRemote.UploadInfo)localObject).jdField_b_of_type_JavaLangString = paramString3;
      ((GameResultUploadMgrForRemote.UploadInfo)localObject).jdField_a_of_type_ComTencentAvgameGameresultGameResultUploadMgrForRemote$GameResultUploadCallback = paramGameResultUploadCallback;
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1, localObject);
      ThreadManagerV2.excute(new GameResultUploadMgrForRemote.2(this, paramString2, (GameResultUploadMgrForRemote.UploadInfo)localObject, paramBaseQQAppInterface, paramString1), 16, null, false);
      return true;
    }
    finally {}
  }
  
  public void b(String paramString)
  {
    try
    {
      boolean bool = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString);
      if (!bool) {
        return;
      }
      Object localObject = (GameResultUploadMgrForRemote.UploadInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if ((!((GameResultUploadMgrForRemote.UploadInfo)localObject).jdField_b_of_type_Boolean) && (!((GameResultUploadMgrForRemote.UploadInfo)localObject).jdField_a_of_type_Boolean))
      {
        String str = ((GameResultUploadMgrForRemote.UploadInfo)localObject).jdField_a_of_type_JavaLangString;
        localObject = ((GameResultUploadMgrForRemote.UploadInfo)localObject).jdField_b_of_type_JavaLangString;
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
        if (QLog.isDevelopLevel()) {
          QLog.i("GameResultUploadMgrForRemote_GameRC", 1, String.format("清理资源[%s]", new Object[] { paramString }));
        }
        ThreadManagerV2.excute(new GameResultUploadMgrForRemote.4(this, str, (String)localObject), 16, null, false);
        return;
      }
      ((GameResultUploadMgrForRemote.UploadInfo)localObject).c = true;
      if (QLog.isDevelopLevel()) {
        QLog.i("GameResultUploadMgrForRemote_GameRC", 1, String.format("视频正在上传[%b], 图片正在上传[%b],需要延迟清理", new Object[] { Boolean.valueOf(((GameResultUploadMgrForRemote.UploadInfo)localObject).jdField_b_of_type_Boolean), Boolean.valueOf(((GameResultUploadMgrForRemote.UploadInfo)localObject).jdField_a_of_type_Boolean) }));
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameresult.GameResultUploadMgrForRemote
 * JD-Core Version:    0.7.0.1
 */