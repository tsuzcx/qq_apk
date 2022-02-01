package com.tencent.comic.api.impl;

import android.os.Bundle;
import com.tencent.comic.api.IQQComicEmoticonService;
import com.tencent.comic.api.IQQComicEmoticonService.IQQComicEmoUploadCallback;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import mqq.app.AppRuntime;
import org.json.JSONObject;
import tencent.im.cs.cmd0x388.cmd0x388.ExtensionCommPicTryUp;

public class QQComicEmoticonServiceImpl
  implements IQQComicEmoticonService
{
  public static final String TAG = "VipComicEmoticonUploader";
  private AppRuntime mApp;
  private ITransFileController mFileController;
  public IQQComicEmoticonService.IQQComicEmoUploadCallback mOnInvokeFinishListener = null;
  private String mUin;
  private UpCallBack mUpCallback = new QQComicEmoticonServiceImpl.1(this);
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
    this.mFileController = ((ITransFileController)paramAppRuntime.getRuntimeService(ITransFileController.class, ""));
    this.mUin = paramAppRuntime.getCurrentUin();
  }
  
  public void onDestroy()
  {
    this.mFileController = null;
    this.mUin = null;
    this.mOnInvokeFinishListener = null;
    this.mApp = null;
  }
  
  public void uploadComicEmoticon(Bundle paramBundle, IQQComicEmoticonService.IQQComicEmoUploadCallback paramIQQComicEmoUploadCallback)
  {
    if (paramBundle == null) {
      return;
    }
    this.mOnInvokeFinishListener = paramIQQComicEmoUploadCallback;
    paramIQQComicEmoUploadCallback = new TransferRequest();
    paramIQQComicEmoUploadCallback.mFileType = 24;
    paramIQQComicEmoUploadCallback.mCommandId = 20;
    paramIQQComicEmoUploadCallback.mRichTag = "actQqComicPicUpload";
    String str1 = this.mUin;
    paramIQQComicEmoUploadCallback.mSelfUin = str1;
    paramIQQComicEmoUploadCallback.mPeerUin = str1;
    paramIQQComicEmoUploadCallback.mIsUp = true;
    paramIQQComicEmoUploadCallback.mLocalPath = paramBundle.getString("localPath");
    paramIQQComicEmoUploadCallback.mUpCallBack = this.mUpCallback;
    str1 = paramBundle.getString("comicId");
    String str2 = paramBundle.getString("picMd5");
    String str3 = paramBundle.getString("actionData");
    paramBundle = new JSONObject();
    try
    {
      paramBundle.put("comicId", str1);
      paramBundle.put("picMd5", str2);
      paramBundle.put("actionData", str3);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    cmd0x388.ExtensionCommPicTryUp localExtensionCommPicTryUp = new cmd0x388.ExtensionCommPicTryUp();
    localExtensionCommPicTryUp.rpt_bytes_extinfo.add(ByteStringMicro.copyFrom(paramBundle.toString().getBytes()));
    paramIQQComicEmoUploadCallback.mExtentionInfo = localExtensionCommPicTryUp.toByteArray();
    paramBundle = this.mFileController;
    if (paramBundle != null) {
      paramBundle.transferAsync(paramIQQComicEmoUploadCallback);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.api.impl.QQComicEmoticonServiceImpl
 * JD-Core Version:    0.7.0.1
 */