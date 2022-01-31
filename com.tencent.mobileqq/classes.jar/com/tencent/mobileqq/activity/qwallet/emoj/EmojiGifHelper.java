package com.tencent.mobileqq.activity.qwallet.emoj;

import ahio;
import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class EmojiGifHelper
{
  private static final String TAG = "EmojiGifHelper";
  private static volatile EmojiGifHelper sInstance;
  private SparseArray<EmojiGifHelper.EmojiInfo> mEmojiInfos = new SparseArray();
  
  public static void compositeAndTransToGif(EmojiGifHelper.ConvertParam paramConvertParam, EmojiGifHelper.OnConvertListener paramOnConvertListener)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime == null) && (paramOnConvertListener != null)) {
      paramOnConvertListener.onConvertResult(false, null);
    }
    if ((localAppRuntime instanceof QQAppInterface))
    {
      getInstance().compositeAndTransToGifInner(paramConvertParam, paramOnConvertListener);
      return;
    }
    ahio.a(paramConvertParam, new EmojiGifHelper.1(paramOnConvertListener));
  }
  
  public static EmojiGifHelper getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new EmojiGifHelper();
      }
      return sInstance;
    }
    finally {}
  }
  
  public static void removeTask(int paramInt)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime == null) {
      return;
    }
    if ((localAppRuntime instanceof QQAppInterface))
    {
      getInstance().removeTaskInner(paramInt);
      return;
    }
    ahio.a(paramInt);
  }
  
  private void sendPicToAIO(EmojiGifHelper.EmojiInfo paramEmojiInfo)
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity == null) {}
    while ((paramEmojiInfo == null) || (paramEmojiInfo.sessionInfo == null) || (TextUtils.isEmpty(paramEmojiInfo.gifPath))) {
      return;
    }
    Intent localIntent = new Intent(localBaseActivity, SendPhotoActivity.class);
    localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1007);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramEmojiInfo.gifPath);
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    localIntent.putExtra("PhotoConst.PHOTO_COUNT", localArrayList.size());
    localIntent.putExtra("uin", paramEmojiInfo.sessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uintype", paramEmojiInfo.sessionInfo.jdField_a_of_type_Int);
    localIntent.putExtra("troop_uin", paramEmojiInfo.sessionInfo.b);
    localIntent.putExtra("key_confess_topicid", paramEmojiInfo.sessionInfo.e);
    localIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
    localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
    localIntent.putExtra("entrance", paramEmojiInfo.sessionInfo.c);
    if (localArrayList.size() == 1) {
      localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", localArrayList);
    }
    localBaseActivity.startActivity(localIntent);
    this.mEmojiInfos.remove(paramEmojiInfo.tag);
  }
  
  public void attachTask(EmojiGifHelper.ConvertParam arg1, EmojiGifHelper.CompositeTask paramCompositeTask)
  {
    if ((??? == null) || (paramCompositeTask == null)) {}
    EmojiGifHelper.EmojiInfo localEmojiInfo;
    do
    {
      return;
      localEmojiInfo = (EmojiGifHelper.EmojiInfo)this.mEmojiInfos.get(???.tag);
    } while (localEmojiInfo == null);
    synchronized (localEmojiInfo.lock)
    {
      if (localEmojiInfo.task != null) {
        localEmojiInfo.task.cancel();
      }
      localEmojiInfo.task = paramCompositeTask;
      paramCompositeTask.emojiInfo = localEmojiInfo;
      return;
    }
  }
  
  public void bind(SessionInfo paramSessionInfo, int paramInt)
  {
    EmojiGifHelper.EmojiInfo localEmojiInfo = new EmojiGifHelper.EmojiInfo();
    localEmojiInfo.sessionInfo = paramSessionInfo;
    localEmojiInfo.tag = paramInt;
    this.mEmojiInfos.put(paramInt, localEmojiInfo);
  }
  
  public void compositeAndTransToGifInner(EmojiGifHelper.ConvertParam paramConvertParam, EmojiGifHelper.OnConvertListener paramOnConvertListener)
  {
    if (paramConvertParam == null)
    {
      if (paramOnConvertListener != null) {
        paramOnConvertListener.onConvertResult(false, null);
      }
      return;
    }
    paramOnConvertListener = new EmojiGifHelper.CompositeTask(this, paramConvertParam, paramOnConvertListener);
    attachTask(paramConvertParam, paramOnConvertListener);
    paramOnConvertListener.run();
  }
  
  public void removeTaskInner(int paramInt)
  {
    EmojiGifHelper.EmojiInfo localEmojiInfo = (EmojiGifHelper.EmojiInfo)this.mEmojiInfos.get(paramInt);
    if (localEmojiInfo != null) {
      localEmojiInfo.removeTask();
    }
  }
  
  public void trySendPicToAIO(int paramInt)
  {
    EmojiGifHelper.EmojiInfo localEmojiInfo1 = (EmojiGifHelper.EmojiInfo)this.mEmojiInfos.get(paramInt);
    if (localEmojiInfo1 == null) {}
    do
    {
      return;
      byte[] arrayOfByte = localEmojiInfo1.lock;
      if (localEmojiInfo1 != null) {
        try
        {
          if (TextUtils.isEmpty(localEmojiInfo1.gifPath))
          {
            if (QLog.isColorLevel()) {
              QLog.i("EmojiGifHelper", 2, "trySendPicToAIO waiting to send");
            }
            localEmojiInfo1.isImmeSend = true;
            return;
          }
        }
        finally {}
      }
      if (QLog.isColorLevel()) {
        QLog.i("EmojiGifHelper", 2, "trySendPicToAIO immediately send");
      }
    } while ((localEmojiInfo2 == null) || (TextUtils.isEmpty(localEmojiInfo2.gifPath)));
    sendPicToAIO(localEmojiInfo2);
  }
  
  public void unbind(int paramInt)
  {
    EmojiGifHelper.EmojiInfo localEmojiInfo = (EmojiGifHelper.EmojiInfo)this.mEmojiInfos.get(paramInt);
    if (localEmojiInfo != null) {
      localEmojiInfo.onDestroy();
    }
    this.mEmojiInfos.remove(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.emoj.EmojiGifHelper
 * JD-Core Version:    0.7.0.1
 */