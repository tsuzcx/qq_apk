package com.tencent.mobileqq.activity.qwallet.redpacket.draw;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;

public class ScribbleBaseOperator
{
  public QQAppInterface a;
  
  public ScribbleBaseOperator(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public MessageForScribble a(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, int paramInt3)
  {
    MessageForScribble localMessageForScribble = (MessageForScribble)MessageRecordFactory.a(-7001);
    MessageRecordFactory.a(this.a, localMessageForScribble, paramString3, paramString3, paramInt2);
    localMessageForScribble.msgtype = -7001;
    localMessageForScribble.offSet = paramInt1;
    localMessageForScribble.gifId = paramInt3;
    localMessageForScribble.localFildPath = paramString1;
    localMessageForScribble.combineFileMd5 = paramString2;
    localMessageForScribble.selfuin = this.a.getCurrentAccountUin();
    localMessageForScribble.senderuin = localMessageForScribble.selfuin;
    localMessageForScribble.issend = 1;
    localMessageForScribble.fileUploadStatus = 0;
    return localMessageForScribble;
  }
  
  public boolean a(MessageForScribble paramMessageForScribble)
  {
    ThreadManager.post(new ScribbleBaseOperator.1(this, paramMessageForScribble), 8, null, false);
    return true;
  }
  
  public boolean a(MessageForScribble paramMessageForScribble, String paramString, UpCallBack paramUpCallBack)
  {
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mIsUp = true;
    localTransferRequest.mFileType = 262153;
    localTransferRequest.mSelfUin = paramMessageForScribble.selfuin;
    localTransferRequest.mPeerUin = paramMessageForScribble.frienduin;
    localTransferRequest.mUinType = paramMessageForScribble.istroop;
    localTransferRequest.mUniseq = paramMessageForScribble.uniseq;
    localTransferRequest.mUpCallBack = paramUpCallBack;
    localTransferRequest.mLocalPath = paramString;
    localTransferRequest.mRec = paramMessageForScribble;
    paramMessageForScribble.fileUploadStatus = 3;
    ((ITransFileController)this.a.getRuntimeService(ITransFileController.class)).transferAsync(localTransferRequest);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.draw.ScribbleBaseOperator
 * JD-Core Version:    0.7.0.1
 */