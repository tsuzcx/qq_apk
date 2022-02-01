package com.tencent.biz.pubaccount.readinjoy.model;

import android.os.Handler;
import bjum;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qgn;
import qhj;
import qxn;
import qxp;
import tencent.im.oidb.cmd0xef5.oidb_cmd0xef5.ReqBody;
import tencent.im.oidb.cmd0xef5.oidb_cmd0xef5.RspBody;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/model/RIJCommentReportModule;", "Lcom/tencent/biz/pubaccount/readinjoy/model/ReadInJoyEngineModule;", "app", "Lcom/tencent/common/app/AppInterface;", "entityManager", "Lcom/tencent/mobileqq/persistence/EntityManager;", "executor", "Ljava/util/concurrent/ExecutorService;", "msfService", "Lcom/tencent/biz/pubaccount/readinjoy/protocol/ReadInJoyMSFService;", "mainThreadHandler", "Landroid/os/Handler;", "(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/persistence/EntityManager;Ljava/util/concurrent/ExecutorService;Lcom/tencent/biz/pubaccount/readinjoy/protocol/ReadInJoyMSFService;Landroid/os/Handler;)V", "onReceive", "", "req", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "res", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "data", "", "requestCommentReport", "commentReportInfo", "Lcom/tencent/biz/pubaccount/readinjoy/model/RIJCommentReportModule$CommentReportInfo;", "unInitialize", "CommentReportInfo", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJCommentReportModule
  extends qhj
{
  public static final qgn a = new qgn(null);
  
  public RIJCommentReportModule(@Nullable AppInterface paramAppInterface, @Nullable EntityManager paramEntityManager, @Nullable ExecutorService paramExecutorService, @Nullable qxn paramqxn, @Nullable Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramqxn, paramHandler);
  }
  
  public void a() {}
  
  public final void a(@Nullable RIJCommentReportModule.CommentReportInfo paramCommentReportInfo)
  {
    HashMap localHashMap = null;
    for (;;)
    {
      try
      {
        oidb_cmd0xef5.ReqBody localReqBody = new oidb_cmd0xef5.ReqBody();
        PBStringField localPBStringField = localReqBody.rowkey;
        if (paramCommentReportInfo != null)
        {
          localObject = paramCommentReportInfo.a();
          localPBStringField.set((String)localObject);
          localPBStringField = localReqBody.first_comment_id;
          if (paramCommentReportInfo == null) {
            continue;
          }
          localObject = paramCommentReportInfo.b();
          localPBStringField.set((String)localObject);
          localPBStringField = localReqBody.sub_comment_id;
          if (paramCommentReportInfo == null) {
            continue;
          }
          localObject = paramCommentReportInfo.c();
          localPBStringField.set((String)localObject);
          localObject = localReqBody.report_type;
          if (paramCommentReportInfo == null) {
            continue;
          }
          i = paramCommentReportInfo.a();
          ((PBUInt32Field)localObject).set(i);
          localPBStringField = localReqBody.report_reason;
          localObject = localHashMap;
          if (paramCommentReportInfo != null) {
            localObject = paramCommentReportInfo.d();
          }
          localPBStringField.set((String)localObject);
          localObject = localReqBody.toByteArray();
          if (QLog.isColorLevel()) {
            QLog.d("RIJCommentReportModule", 2, "requestCommentReport(): CommentReportInfo:" + paramCommentReportInfo + ", byteArray.length:" + localObject.length);
          }
          localObject = qxp.a("OidbSvc.0xef5", 3829, 1, (byte[])localObject);
          if (localObject != null)
          {
            localHashMap = ((ToServiceMsg)localObject).getAttributes();
            if (localHashMap != null) {
              localHashMap.put("requestCommentReportInfo", paramCommentReportInfo);
            }
          }
          a((ToServiceMsg)localObject);
          return;
        }
      }
      catch (Throwable paramCommentReportInfo)
      {
        Object localObject;
        int i;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("RIJCommentReportModule", 2, "requestCommentReport() failed.", paramCommentReportInfo);
      }
      localObject = null;
      continue;
      localObject = null;
      continue;
      localObject = null;
      continue;
      i = 0;
    }
  }
  
  public void a(@NotNull ToServiceMsg paramToServiceMsg, @NotNull FromServiceMsg paramFromServiceMsg, @NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramToServiceMsg, "req");
    Intrinsics.checkParameterIsNotNull(paramFromServiceMsg, "res");
    Intrinsics.checkParameterIsNotNull(paramObject, "data");
    if (QLog.isColorLevel()) {
      QLog.d("RIJCommentReportModule", 2, "onReceive(): FromServiceMsg:" + paramFromServiceMsg + ", ToServiceMsg:" + paramToServiceMsg);
    }
    int i;
    int j;
    if (Intrinsics.areEqual(paramFromServiceMsg.getServiceCmd(), "OidbSvc.0xef5"))
    {
      oidb_cmd0xef5.RspBody localRspBody = new oidb_cmd0xef5.RspBody();
      i = qxp.a(paramFromServiceMsg, paramObject, (MessageMicro)localRspBody);
      j = localRspBody.ret.get();
      paramFromServiceMsg = localRspBody.err_message.get();
      paramToServiceMsg = paramToServiceMsg.getAttributes();
      if (paramToServiceMsg == null) {
        break label224;
      }
      paramToServiceMsg = paramToServiceMsg.get("requestCommentReportInfo");
      paramToServiceMsg = (RIJCommentReportModule.CommentReportInfo)paramToServiceMsg;
      if ((i != 0) || (j != 0)) {
        break label229;
      }
    }
    label224:
    label229:
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RIJCommentReportModule", 2, "onReceive(): result:" + i + ", retCode:" + j + ", errMsg:" + paramFromServiceMsg + ", commentReportInfo:" + paramToServiceMsg);
      }
      bjum.c((Runnable)new RIJCommentReportModule.onReceive.1(bool, j, paramFromServiceMsg, paramToServiceMsg));
      return;
      paramToServiceMsg = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.RIJCommentReportModule
 * JD-Core Version:    0.7.0.1
 */