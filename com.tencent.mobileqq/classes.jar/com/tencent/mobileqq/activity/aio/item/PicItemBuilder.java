package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.os.Process;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.image.GifDrawable;
import com.tencent.image.NativeGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.TouchDelegate;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.FileTransferManager.Callback;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.customviews.PicProgressView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.doutu.DoutuItem;
import com.tencent.mobileqq.doutu.DuiButtonImageView;
import com.tencent.mobileqq.drawable.BitmapDrawableWithMargin;
import com.tencent.mobileqq.drawable.EmptyDrawable;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpic.HotPicHelper;
import com.tencent.mobileqq.lightReply.LightReplyEmojs;
import com.tencent.mobileqq.lightReply.LightReplyMenuManager;
import com.tencent.mobileqq.lightReply.LightReplyMenuManager.LightReplyEmotionClickListener;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.nearby.HotChatUtil;
import com.tencent.mobileqq.ocr.OCRManager;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicContants;
import com.tencent.mobileqq.pic.PicDownloadInfo.Builder;
import com.tencent.mobileqq.pic.PicFowardInfo;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.pic.PicUploadInfo.Builder;
import com.tencent.mobileqq.pic.PicUploadInfo.RetryInfo;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.GeneralConfigUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.BaseUploadProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.PicFowardDbRecordData;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import com.tencent.mobileqq.transfile.TranDbRecord.PicDbRecord;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.mobileqq.troop.utils.TroopTopicMgr;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.mobileqq.widget.PhotoProgressDrawable;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.peak.PeakUtils;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URL;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import vhn;
import vho;
import vhp;
import vhq;
import vhr;
import vhs;
import vht;
import vhv;

public class PicItemBuilder
  extends QIMTailItemBubbleBuilder
  implements BaseBubbleBuilder.TouchDelegate, FileTransferManager.Callback, LightReplyMenuManager.LightReplyEmotionClickListener
{
  public static int b;
  public static float c;
  public static int c;
  public static long c;
  public static float d;
  public static boolean d;
  static long e;
  public static boolean e;
  public static boolean f;
  protected LightReplyMenuManager a;
  protected final float b;
  protected final boolean c;
  public long d;
  boolean g = false;
  boolean h = true;
  boolean i = false;
  boolean j = false;
  
  static
  {
    jdField_e_of_type_Boolean = true;
    jdField_b_of_type_Int = 100;
    jdField_c_of_type_Long = 1000L;
    jdField_c_of_type_Float = 0.3F;
    jdField_d_of_type_Float = 1.0F;
    URLDrawableHelper.a();
    jdField_e_of_type_Long = 1000L;
  }
  
  public PicItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    this(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner, false);
  }
  
  public PicItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, boolean paramBoolean)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_c_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager = LightReplyMenuManager.a();
  }
  
  public static Bitmap a()
  {
    Drawable localDrawable = BaseApplicationImpl.getContext().getResources().getDrawable(2130837705);
    if (localDrawable != null)
    {
      if ((localDrawable instanceof BitmapDrawable)) {
        return ((BitmapDrawable)localDrawable).getBitmap();
      }
      if ((localDrawable instanceof SkinnableBitmapDrawable)) {
        return ((SkinnableBitmapDrawable)localDrawable).getBitmap();
      }
    }
    return null;
  }
  
  public static URLDrawable a(Context paramContext, MessageForPic paramMessageForPic)
  {
    return a(paramContext, paramMessageForPic, null, null);
  }
  
  public static URLDrawable a(Context paramContext, MessageForPic paramMessageForPic, ChatThumbView paramChatThumbView)
  {
    return a(paramContext, paramMessageForPic, paramChatThumbView, null);
  }
  
  public static URLDrawable a(Context paramContext, MessageForPic paramMessageForPic, ChatThumbView paramChatThumbView, int[] paramArrayOfInt)
  {
    Object localObject1 = null;
    boolean bool2 = false;
    boolean bool1 = false;
    Object localObject9 = null;
    Object localObject4 = null;
    boolean bool3 = PeakUtils.a(paramMessageForPic.imageType);
    Object localObject7;
    File localFile;
    if ((paramMessageForPic.imageType == 3) || (paramMessageForPic.imageType == 2000))
    {
      e();
      if (jdField_e_of_type_Boolean)
      {
        localObject7 = URLDrawableHelper.a(paramMessageForPic, 1, null);
        localFile = AbsDownloader.a(((URL)localObject7).toString());
        if (localFile == null) {}
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = NativeGifImage.getImageSize(localFile, false);
        bool1 = true;
        continue;
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("PicItemBuilder", 2, "getThumbDrawable,using GIF_BIG,uniseq:" + paramMessageForPic.uniseq + " url:" + localObject7);
          }
          bool1 = true;
          localObject4 = localObject1;
          localObject1 = localObject7;
          localObject7 = localObject1;
          if (localObject1 == null)
          {
            localObject1 = URLDrawableHelper.a(paramMessageForPic, 65537, null);
            localObject7 = localObject1;
            if (QLog.isColorLevel())
            {
              QLog.d("PicItemBuilder", 2, "getThumbDrawable,using thumb,uniseq:" + paramMessageForPic.uniseq + " url:" + localObject1);
              localObject7 = localObject1;
            }
          }
          localObject9 = ((URL)localObject7).toString();
          localObject1 = paramContext.getResources();
          i3 = ((Resources)localObject1).getDisplayMetrics().densityDpi;
          if (paramChatThumbView != null) {
            paramChatThumbView.jdField_a_of_type_Boolean = false;
          }
          f1 = i3 / 160.0F;
          if (BaseApplicationImpl.sImageCache.get(localObject9) == null) {
            break label477;
          }
          paramContext = URLDrawableHelper.a((URL)localObject7, 0, 0, null, null, true, f1 * 12.0F);
          if (paramArrayOfInt != null)
          {
            paramArrayOfInt[0] = paramContext.getIntrinsicWidth();
            paramArrayOfInt[1] = paramContext.getIntrinsicHeight();
          }
          paramContext.setTag(paramMessageForPic);
          if ((paramContext.getCurrDrawable() instanceof GifDrawable)) {
            ((GifDrawable)paramContext.getCurrDrawable()).mutate();
          }
          return paramContext;
        }
        catch (Throwable localThrowable4)
        {
          for (;;)
          {
            int i3;
            float f1;
            Object localObject2;
            Object localObject8;
            localObject6 = localObject3;
            localObject3 = localObject8;
          }
        }
        localThrowable1 = localThrowable1;
        localObject2 = null;
      }
      if ((HotPicHelper.a(paramMessageForPic)) && (paramMessageForPic.isSendFromLocal()))
      {
        localObject4 = paramMessageForPic.getPicUploadInfo();
        ((PicUploadInfo)localObject4).f = paramMessageForPic.getExtInfoFromExtStr("hot_pic_thumb_md5");
        localObject4 = URLDrawableHelper.a((PicUploadInfo)localObject4, 1, null);
        localObject7 = AbsDownloader.a(((URL)localObject4).toString());
        if (localObject7 != null)
        {
          try
          {
            localObject7 = NativeGifImage.getImageSize((File)localObject7, false);
            localObject2 = localObject7;
            bool1 = true;
          }
          catch (Throwable localThrowable3)
          {
            try
            {
              if (QLog.isColorLevel()) {
                QLog.d("PicItemBuilder", 2, "getThumbDrawable,using GIF_HOT_PIC,uniseq:" + paramMessageForPic.uniseq + " url:" + localObject4);
              }
              localObject7 = localObject2;
              bool1 = true;
              localObject2 = localObject4;
              localObject4 = localObject7;
            }
            catch (Throwable localThrowable5)
            {
              for (;;)
              {
                int m;
                int k;
                int i1;
                int n;
                float f2;
                int i2;
                localObject8 = localObject5;
                Object localObject5 = localThrowable2;
                localObject3 = localObject8;
              }
            }
            localThrowable3 = localThrowable3;
            bool1 = bool2;
            localObject5 = localObject9;
          }
          continue;
          label477:
          localObject9 = AbsDownloader.a((String)localObject9);
          if (localObject9 != null)
          {
            if (localObject5 != null)
            {
              m = ((Rect)localObject5).width();
              k = ((Rect)localObject5).height();
              label508:
              i1 = URLDrawableHelper.c(bool3);
              n = URLDrawableHelper.d(bool3);
              f1 *= 12.0F;
              if ((m >= n) && (k >= n)) {
                break label863;
              }
              if (m >= k) {
                break label816;
              }
              f2 = n / m;
              m = (int)(k * f2 + 0.5F);
              k = m;
              if (m > i1) {
                k = i1;
              }
              m = n;
              f1 = f2 * f1;
              label598:
              m = (m * i3 + 80) / 160;
              k = (k * i3 + 80) / 160;
              if (localObject5 == null) {
                break label1600;
              }
              if (((Rect)localObject5).width() >= m) {
                break label974;
              }
            }
            for (f1 *= ((Rect)localObject5).width() / m;; f1 *= ((Rect)localObject5).height() / k)
            {
              for (;;)
              {
                if (paramArrayOfInt != null)
                {
                  paramArrayOfInt[0] = m;
                  paramArrayOfInt[1] = k;
                }
                paramContext = URLDrawableHelper.a((URL)localObject7, m, k, new EmptyDrawable(m, k), URLDrawableHelper.a(), true, f1);
                paramContext.setIgnorePause(true);
                paramContext.setFadeInImage(true);
                if (paramChatThumbView != null) {
                  paramChatThumbView.jdField_a_of_type_Boolean = true;
                }
                break;
                paramContext = new BitmapFactory.Options();
                paramContext.inJustDecodeBounds = true;
                try
                {
                  ImageUtil.a(((File)localObject9).getAbsolutePath(), paramContext);
                  m = paramContext.outWidth;
                  k = paramContext.outHeight;
                  n = URLDrawableHelper.a(((File)localObject9).getAbsolutePath());
                  if ((n != 90) && (n != 270)) {
                    break label508;
                  }
                  m = paramContext.outHeight;
                  k = paramContext.outWidth;
                }
                catch (Throwable localThrowable2)
                {
                  for (;;)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.e("PicItemBuilder", 2, "getThumbDrawable", localThrowable2);
                    }
                  }
                }
              }
              label816:
              f2 = n / k;
              k = (int)(m * f2 + 0.5F);
              if (k > i1) {
                k = i1;
              }
              for (;;)
              {
                m = k;
                k = n;
                break;
              }
              label863:
              if ((m < i1) && (k < i1)) {
                break label598;
              }
              if (m > k)
              {
                f2 = i1 / m;
                label896:
                if (m <= k) {
                  break label962;
                }
              }
              label962:
              for (float f3 = n / k;; f3 = n / m)
              {
                f2 = Math.max(f2, f3);
                m = (int)(m * f2 + 0.5F);
                k = (int)(k * f2 + 0.5F);
                break;
                f2 = i1 / k;
                break label896;
              }
              label974:
              if (((Rect)localObject5).height() >= k) {
                break label1600;
              }
            }
          }
          else
          {
            if (!URLDrawableHelper.a(paramContext))
            {
              n = 1;
              label1012:
              k = URLDrawableHelper.c(bool3);
              m = URLDrawableHelper.d(bool3);
              i1 = paramMessageForPic.thumbWidth;
              i2 = paramMessageForPic.thumbHeight;
              if ((i1 <= 0) || (i2 <= 0)) {
                break label1466;
              }
              if ((i1 >= m) && (i2 >= m)) {
                break label1347;
              }
              if (i1 >= i2) {
                break label1300;
              }
              f1 = m / i1;
              i1 = (int)(i2 * f1 + 0.5F);
              if (i1 <= k) {
                break label1293;
              }
              label1098:
              f1 = i3 / 160.0F;
              m = (int)(m * f1 + 0.5F);
              k = (int)(k * f1 + 0.5F);
              paramContext = null;
              paramChatThumbView = URLDrawable.URLDrawableOptions.obtain();
              paramChatThumbView.mRequestWidth = m;
              paramChatThumbView.mRequestHeight = k;
              paramChatThumbView.mLoadingDrawable = URLDrawableHelper.b();
              paramChatThumbView.mFailedDrawable = URLDrawableHelper.a();
              paramChatThumbView.mPlayGifImage = bool1;
              paramChatThumbView.mGifRoundCorner = 12.0F;
              paramChatThumbView.mImgType = paramMessageForPic.imageType;
              if (paramArrayOfInt != null)
              {
                paramArrayOfInt[0] = m;
                paramArrayOfInt[1] = k;
              }
              if (!(URLDrawableHelper.b() instanceof SkinnableBitmapDrawable)) {
                break label1521;
              }
              paramContext = new BitmapDrawableWithMargin(localThrowable2, ((SkinnableBitmapDrawable)URLDrawableHelper.b()).getBitmap(), m, k, -921103);
              label1236:
              if (paramContext != null) {
                paramChatThumbView.mLoadingDrawable = paramContext;
              }
              paramContext = URLDrawable.getDrawable((URL)localObject7, paramChatThumbView);
              if ((!PicContants.jdField_b_of_type_Boolean) && (n == 0)) {
                break label1562;
              }
              paramContext.setAutoDownload(true);
            }
            for (;;)
            {
              paramContext.setProgressDrawable(new PhotoProgressDrawable(URLDrawableHelper.a(), 0, false));
              break;
              n = 0;
              break label1012;
              label1293:
              k = i1;
              break label1098;
              label1300:
              i1 = (int)(m / i2 * i1 + 0.5F);
              if (i1 > k) {}
              for (;;)
              {
                i1 = k;
                k = m;
                m = i1;
                break;
                k = i1;
              }
              label1347:
              if ((i1 < k) && (i2 < k))
              {
                k = i2;
                m = i1;
                break label1098;
              }
              if (i1 > i2)
              {
                f1 = k / i1;
                label1388:
                if (i1 <= i2) {
                  break label1454;
                }
              }
              label1454:
              for (f2 = m / i2;; f2 = m / i1)
              {
                f1 = Math.max(f1, f2);
                m = (int)(i1 * f1 + 0.5F);
                k = (int)(f1 * i2 + 0.5F);
                break;
                f1 = k / i2;
                break label1388;
              }
              label1466:
              if (QLog.isColorLevel()) {
                QLog.d("PicItemBuilder", 2, "MessageForPic without width/height of thumb, width = " + i1 + ", height = " + i2);
              }
              m = 99;
              k = 99;
              break label1098;
              label1521:
              if (!(URLDrawableHelper.b() instanceof BitmapDrawable)) {
                break label1236;
              }
              paramContext = new BitmapDrawableWithMargin(localThrowable2, ((BitmapDrawable)URLDrawableHelper.b()).getBitmap(), m, k, -921103);
              break label1236;
              label1562:
              paramContext.setAutoDownload(false);
            }
          }
        }
      }
      label1600:
      Object localObject6 = null;
      bool1 = false;
      Object localObject3 = null;
    }
  }
  
  public static URL a(MessageForPic paramMessageForPic)
  {
    URL localURL1;
    if (((paramMessageForPic.imageType == 3) || (paramMessageForPic.imageType == 2000)) && (jdField_e_of_type_Boolean))
    {
      localURL1 = URLDrawableHelper.a(paramMessageForPic, 1, null);
      if (AbsDownloader.a(localURL1.toString()) == null) {}
    }
    for (;;)
    {
      URL localURL2 = localURL1;
      if (localURL1 == null) {
        localURL2 = URLDrawableHelper.a(paramMessageForPic, 65537, null);
      }
      return localURL2;
      localURL1 = null;
    }
  }
  
  public static void a(Context paramContext, View paramView, ChatMessage paramChatMessage, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    a(null, paramContext, paramView, paramChatMessage, paramSessionInfo, paramBoolean);
  }
  
  private void a(PicItemBuilder.Holder paramHolder)
  {
    if ((paramHolder != null) && (paramHolder.b != null)) {
      paramHolder.b.setVisibility(8);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, View paramView, ChatMessage paramChatMessage, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    Object localObject = LightReplyMenuManager.a();
    if ((localObject != null) && (((LightReplyMenuManager)localObject).b())) {
      ((LightReplyMenuManager)localObject).a();
    }
    paramView = AnimationUtils.a(paramView);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("KEY_THUMBNAL_BOUND", paramView);
    if ((((paramContext instanceof ChatActivity)) || ((paramContext instanceof SplashActivity))) && (!(paramContext instanceof MultiForwardActivity)))
    {
      paramView = ((FragmentActivity)paramContext).getChatFragment();
      if (paramView == null) {
        QLog.d("PicItemBuilder", 1, "enterImagePreview  chatFragment is null.");
      }
    }
    else
    {
      if (paramSessionInfo.jdField_a_of_type_Int == 1)
      {
        localBundle.putBoolean("extra.CAN_FORWARD_TO_GROUP_ALBUM", true);
        localBundle.putString("extra.GROUP_UIN", paramSessionInfo.jdField_a_of_type_JavaLangString);
        localBundle.putString("extra.GROUP_CODE", paramSessionInfo.b);
        localBundle.putString("extra.SENDER_UIN", paramChatMessage.senderuin);
        localBundle.putLong("extra.MESSAGE_SEQ", paramChatMessage.msgseq);
        localBundle.putBoolean("extra.IS_HOT_CHAT", HotChatUtil.a(paramChatMessage));
        localBundle.putBoolean("extra.show_light_reply", paramBoolean);
      }
      if ((paramSessionInfo.jdField_a_of_type_Int != 1) && (paramSessionInfo.jdField_a_of_type_Int != 3000)) {
        break label462;
      }
      localBundle.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 2);
      label207:
      localBundle.putBoolean("extra.IS_FROM_MULTI_MSG", paramChatMessage.isMultiMsg);
      localBundle.putInt("extra.MOBILE_QQ_PROCESS_ID", Process.myPid());
      localObject = paramChatMessage.selfuin;
      paramView = (View)localObject;
      if (!paramChatMessage.isMultiMsg) {}
    }
    try
    {
      AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
      paramView = (View)localObject;
      if ((localAppRuntime instanceof QQAppInterface)) {
        paramView = localAppRuntime.getAccount();
      }
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        paramView.printStackTrace();
        paramView = (View)localObject;
      }
    }
    paramBoolean = OCRManager.a(paramChatMessage.selfuin, 1);
    localBundle.putBoolean("extra.OCR", paramBoolean);
    if (paramBoolean)
    {
      localObject = OCRManager.a(paramChatMessage.selfuin);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localBundle.putString("extra.OCR_TEXT", (String)localObject);
      }
    }
    localBundle.putInt("forward_source_uin_type", paramSessionInfo.jdField_a_of_type_Int);
    localBundle.putString("uin", paramChatMessage.frienduin);
    paramSessionInfo = new AIOImageProviderService(paramView, paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage);
    if ((paramView == null) || (paramChatMessage.frienduin == null)) {
      if (QLog.isColorLevel()) {
        QLog.i("PicItemBuilder", 2, "PicItemBuilder.enterImagePreview() selfUin || pic.frienduin is null");
      }
    }
    for (;;)
    {
      return;
      paramView = paramView.a();
      if (paramView == null)
      {
        QLog.d("PicItemBuilder", 1, "enterImagePreview  BaseChatPie is null.");
        break;
      }
      int k = paramView.f();
      localBundle.putInt("extra.AIO_CURRENT_PANEL_STATE", k);
      if (k != 1) {
        break;
      }
      paramView = (InputMethodManager)paramContext.getSystemService("input_method");
      if (paramView == null) {
        break;
      }
      paramView.toggleSoftInput(1, 0);
      break;
      label462:
      localBundle.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 1);
      break label207;
      if ((paramChatMessage instanceof MessageForPic)) {
        PeakUtils.a(paramContext, localBundle, paramSessionInfo, AIOGalleryUtils.a((MessageForPic)paramChatMessage), -1);
      }
      while (QLog.isColorLevel())
      {
        QLog.i("PicItemBuilder", 2, "PicItemBuilder.enterImagePreview()");
        return;
        if ((paramChatMessage instanceof MessageForTroopFile)) {
          PeakUtils.a(paramContext, localBundle, paramSessionInfo, AIOGalleryUtils.a((MessageForTroopFile)paramChatMessage, paramQQAppInterface), -1);
        }
      }
    }
  }
  
  public static void a(MessageForPic paramMessageForPic, String paramString1, String paramString2)
  {
    a(paramMessageForPic, paramString1, paramString2, null);
  }
  
  public static void a(MessageForPic paramMessageForPic, String paramString1, String paramString2, Throwable paramThrowable)
  {
    RichMediaUtil.a(paramMessageForPic.istroop, paramMessageForPic.isSendFromLocal(), 65537, String.valueOf(paramMessageForPic.uniseq), "PicItemBuilder." + paramString1, paramString2, paramThrowable);
  }
  
  private void a(IHttpCommunicatorListener paramIHttpCommunicatorListener, PicItemBuilder.Holder paramHolder)
  {
    if (paramHolder.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    if ((paramIHttpCommunicatorListener instanceof BaseTransProcessor))
    {
      paramIHttpCommunicatorListener = (BaseTransProcessor)paramIHttpCommunicatorListener;
      int k = (int)paramIHttpCommunicatorListener.c();
      switch (k)
      {
      default: 
        if (paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null)
        {
          paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
          if (paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.a(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq)) {
            break label684;
          }
          paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.b(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
          paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProcessor(null);
          ((RelativeLayout)paramHolder.jdField_a_of_type_AndroidViewView).removeView(paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView);
          paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = null;
        }
        break;
      }
      for (;;)
      {
        if (k == 1003) {
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        }
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
        return;
        if ((paramIHttpCommunicatorListener.a()) && (!this.g))
        {
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
          if (paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null)
          {
            paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
            paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.b(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
            paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProcessor(null);
            ((RelativeLayout)paramHolder.jdField_a_of_type_AndroidViewView).removeView(paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView);
            paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = null;
          }
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
        }
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
        if (paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView == null) {
          break;
        }
        paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.jdField_a_of_type_Boolean = true;
        return;
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        if (paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView == null)
        {
          PicProgressView localPicProgressView = new PicProgressView(this.jdField_a_of_type_AndroidContentContext);
          localPicProgressView.setRadius(this.jdField_b_of_type_Float * 12.0F, false);
          localPicProgressView.setSharpCornerCor(BubbleImageView.a);
          localPicProgressView.setShowCorner(false);
          localPicProgressView.setCustomSize(1);
          localPicProgressView.setProgressBackgroudColor(2130706432);
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams.addRule(6, 2131366638);
          localLayoutParams.addRule(8, 2131366638);
          localLayoutParams.addRule(5, 2131366638);
          localLayoutParams.addRule(7, 2131366638);
          ((RelativeLayout)paramHolder.jdField_a_of_type_AndroidViewView).addView(localPicProgressView, localLayoutParams);
          paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = localPicProgressView;
        }
        paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProcessor(paramIHttpCommunicatorListener);
        paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setVisibility(0);
        if ((paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null) && ((1001 == k) || (1002 == k))) {
          paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.jdField_a_of_type_Boolean = false;
        }
        if (k != 1002)
        {
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
          paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgress(0);
          return;
        }
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
        paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.a();
        paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setShowProgress(true);
        return;
        label684:
        paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgress(100);
      }
    }
    if (paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null)
    {
      paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.b(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProcessor(null);
      ((RelativeLayout)paramHolder.jdField_a_of_type_AndroidViewView).removeView(paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView);
      paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = null;
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
  }
  
  private void a(String paramString)
  {
    ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).b(paramString, new vho(this, paramString));
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      bool1 = bool2;
      if ((paramContext instanceof FragmentActivity))
      {
        paramContext = ((FragmentActivity)paramContext).getChatFragment();
        bool1 = bool2;
        if (paramContext != null)
        {
          bool1 = bool2;
          if (paramContext.a() != null) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, URL paramURL)
  {
    float f1 = paramContext.getResources().getDisplayMetrics().density;
    boolean bool2 = GeneralConfigUtils.a();
    if (!bool2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("t_gif", 2, "needShowGifTag isbigThumb false");
      }
      return false;
    }
    paramContext = AbsDownloader.d(paramURL.toString());
    if ((paramContext != null) && (paramContext.endsWith("_big400"))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("t_gif", 2, "needShowGifTag isgif=" + paramBoolean1 + "isthumb=" + paramBoolean2 + "w=" + paramInt1 + "h=" + paramInt2 + "==100*density=" + 100.0F * f1 + "isbugThumb=" + bool2 + "isthumb400=" + bool1);
      }
      if ((!paramBoolean1) || (!paramBoolean2) || (paramInt1 < 100.0F * f1) || (paramInt2 < f1 * 100.0F) || (!bool2) || (!bool1)) {
        break;
      }
      return true;
    }
  }
  
  private boolean a(MessageForPic paramMessageForPic)
  {
    return AbsDownloader.a(URLDrawableHelper.a(paramMessageForPic, 1, null).toString()) != null;
  }
  
  private void b(BaseChatItemLayout paramBaseChatItemLayout, MessageForPic paramMessageForPic, OnLongClickAndTouchListener paramOnLongClickAndTouchListener, PicItemBuilder.Holder paramHolder)
  {
    if ((paramBaseChatItemLayout == null) || (paramOnLongClickAndTouchListener == null) || (paramHolder == null) || (paramMessageForPic == null) || (paramHolder.jdField_a_of_type_ComTencentImageURLDrawable == null)) {
      return;
    }
    URL localURL = a(paramMessageForPic);
    paramHolder.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new vhv(this, localURL, paramBaseChatItemLayout, paramMessageForPic, paramOnLongClickAndTouchListener, paramHolder));
    if ((!(this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity)) && (paramHolder.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 1))
    {
      a(paramBaseChatItemLayout, paramMessageForPic, paramOnLongClickAndTouchListener, paramHolder);
      return;
    }
    a(paramHolder);
  }
  
  private void b(MessageForPic paramMessageForPic)
  {
    ThreadManager.post(new vhs(this, paramMessageForPic), 5, null, false);
    if (paramMessageForPic.isSendFromLocal()) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForPic.frienduin, paramMessageForPic.uniseq));
    }
    PicUploadInfo.Builder localBuilder = new PicUploadInfo.Builder();
    localBuilder.a(paramMessageForPic.path);
    localBuilder.d(5);
    localBuilder.d(paramMessageForPic.frienduin);
    if (paramMessageForPic.fileSizeFlag == 1) {
      localBuilder.c(TranDbRecord.PicDbRecord.e);
    }
    for (;;)
    {
      localBuilder.e(paramMessageForPic.senderuin);
      localBuilder.c(paramMessageForPic.selfuin);
      localBuilder.e(paramMessageForPic.istroop);
      localBuilder.l(paramMessageForPic.getConfessTopicId());
      localBuilder.jdField_i_of_type_Int = paramMessageForPic.extLong;
      localBuilder.jdField_i_of_type_JavaLangString = paramMessageForPic.extStr;
      Object localObject = new PicUploadInfo.RetryInfo();
      ((PicUploadInfo.RetryInfo)localObject).jdField_a_of_type_Long = paramMessageForPic.msgseq;
      ((PicUploadInfo.RetryInfo)localObject).jdField_b_of_type_Long = paramMessageForPic.shmsgseq;
      ((PicUploadInfo.RetryInfo)localObject).jdField_c_of_type_Long = paramMessageForPic.msgUid;
      localBuilder.a((PicUploadInfo.RetryInfo)localObject);
      localObject = PicBusiManager.a(4, 5);
      ((PicReq)localObject).a(localBuilder.a());
      ((PicReq)localObject).a = paramMessageForPic.picExtraData;
      PicBusiManager.a((PicReq)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
      localBuilder.c(TranDbRecord.PicDbRecord.d);
    }
  }
  
  private void c(MessageForPic paramMessageForPic)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForPic.selfuin, paramMessageForPic.uniseq);
    if ((localObject1 != null) && ((localObject1 instanceof BaseUploadProcessor)))
    {
      ((BaseUploadProcessor)localObject1).ar_();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramMessageForPic.frienduin, paramMessageForPic.istroop, paramMessageForPic.uniseq);
    if (paramMessageForPic.isSendFromLocal()) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForPic.frienduin, paramMessageForPic.uniseq));
    }
    localObject1 = new PicFowardInfo();
    Object localObject2 = new PicUploadInfo.Builder();
    ((PicUploadInfo.Builder)localObject2).d(1009);
    ((PicUploadInfo.Builder)localObject2).a(paramMessageForPic.path);
    ((PicUploadInfo.Builder)localObject2).e(paramMessageForPic.istroop);
    ((PicUploadInfo.Builder)localObject2).c(paramMessageForPic.selfuin);
    ((PicUploadInfo.Builder)localObject2).e(paramMessageForPic.senderuin);
    ((PicUploadInfo.Builder)localObject2).d(paramMessageForPic.frienduin);
    ((PicUploadInfo.Builder)localObject2).jdField_i_of_type_Int = paramMessageForPic.extLong;
    ((PicUploadInfo.Builder)localObject2).jdField_i_of_type_JavaLangString = paramMessageForPic.extStr;
    ((PicUploadInfo.Builder)localObject2).c(TranDbRecord.PicDbRecord.f);
    ((PicFowardInfo)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo = ((PicUploadInfo.Builder)localObject2).a();
    if ((!FileUtils.b(paramMessageForPic.path)) && ((paramMessageForPic.picExtraObject instanceof PicFowardDbRecordData)))
    {
      localObject2 = (PicFowardDbRecordData)paramMessageForPic.picExtraObject;
      PicDownloadInfo.Builder localBuilder = new PicDownloadInfo.Builder();
      localBuilder.a(1009);
      localBuilder.a(paramMessageForPic.selfuin);
      localBuilder.b(((PicFowardDbRecordData)localObject2).jdField_a_of_type_JavaLangString);
      localBuilder.b(((PicFowardDbRecordData)localObject2).jdField_a_of_type_Int);
      localBuilder.c(((PicFowardDbRecordData)localObject2).b);
      localBuilder.a(((PicFowardDbRecordData)localObject2).jdField_a_of_type_Long);
      localBuilder.d(paramMessageForPic.md5);
      localBuilder.c(paramMessageForPic.issend);
      ((PicFowardInfo)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo = localBuilder.a();
    }
    paramMessageForPic = PicBusiManager.a(3, 1009);
    paramMessageForPic.a((PicFowardInfo)localObject1);
    PicBusiManager.a(paramMessageForPic, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public static void e()
  {
    Object localObject;
    if (!jdField_d_of_type_Boolean)
    {
      localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.aio_gifplay.name());
      if ((localObject != null) && (((String)localObject).length() > 0))
      {
        localObject = ((String)localObject).split("\\|");
        if (localObject.length >= 3) {
          jdField_e_of_type_Boolean = localObject[0].equals("1");
        }
      }
    }
    try
    {
      jdField_b_of_type_Int = Integer.parseInt(localObject[2]);
      if (jdField_b_of_type_Int < 0) {
        jdField_b_of_type_Int = 100;
      }
      com.tencent.image.AbstractGifImage.DoAccumulativeRunnable.DELAY = jdField_b_of_type_Int;
      jdField_d_of_type_Boolean = true;
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        jdField_b_of_type_Int = 100;
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    MessageForPic localMessageForPic = (MessageForPic)paramChatMessage;
    boolean bool = PeakUtils.a(localMessageForPic.imageType);
    try
    {
      paramViewHolder = (PicItemBuilder.Holder)paramViewHolder;
      if (paramViewHolder == null) {
        return paramView;
      }
    }
    catch (Exception paramViewHolder)
    {
      for (;;)
      {
        QLog.e("PicItemBuilder", 2, "picitem holer Exception e= " + paramViewHolder);
        paramViewHolder = null;
      }
      Object localObject1 = paramView;
      Object localObject2;
      if (paramView == null)
      {
        localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
        ((RelativeLayout)localObject1).setId(2131366638);
        paramView = new BubbleImageView(this.jdField_a_of_type_AndroidContentContext);
        k = Build.VERSION.SDK_INT;
        if ((k == 19) || (k == 18)) {
          paramView.jdField_e_of_type_Boolean = true;
        }
        paramView.setId(2131366638);
        paramView.setAdjustViewBounds(true);
        paramView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramView.setRadius(12.0F);
        paramView.d(false);
        paramView.setShowEdge(true);
        localObject2 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject2).addRule(15);
        ((RelativeLayout)localObject1).addView(paramView, (ViewGroup.LayoutParams)localObject2);
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = paramView;
        paramView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        localObject2 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131366638);
        ((RelativeLayout.LayoutParams)localObject2).addRule(8, 2131366638);
        ((RelativeLayout)localObject1).addView(paramView, (ViewGroup.LayoutParams)localObject2);
        paramViewHolder.jdField_a_of_type_AndroidWidgetImageView = paramView;
        ((View)localObject1).setOnClickListener(this);
        ((View)localObject1).setOnTouchListener(paramOnLongClickAndTouchListener);
        ((View)localObject1).setOnLongClickListener(paramOnLongClickAndTouchListener);
      }
      paramView = paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView;
      int k = URLDrawableHelper.a(bool);
      int m = URLDrawableHelper.b(bool);
      paramView.setMaxWidth(k);
      paramView.setMaxHeight(k);
      paramView.setMinimumWidth(m);
      paramView.setMinimumHeight(m);
      if (jdField_b_of_type_Boolean) {
        paramView.setContentDescription("图片");
      }
      paramView = FileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (paramView != null) {
        paramView.a((View)localObject1, this);
      }
      int[] arrayOfInt;
      if (!localMessageForPic.isSendFromLocal())
      {
        if (paramViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null)
        {
          paramViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setVisibility(8);
          paramViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(localMessageForPic.frienduin + localMessageForPic.uniseq);
          paramViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.b(localMessageForPic.frienduin + localMessageForPic.uniseq);
          paramViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProcessor(null);
          ((RelativeLayout)paramViewHolder.jdField_a_of_type_AndroidViewView).removeView(paramViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView);
          paramViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = null;
        }
        URL localURL = a(localMessageForPic);
        arrayOfInt = new int[2];
        int[] tmp475_473 = arrayOfInt;
        tmp475_473[0] = 0;
        int[] tmp479_475 = tmp475_473;
        tmp479_475[1] = 0;
        tmp479_475;
        if ((paramViewHolder.jdField_a_of_type_ComTencentImageURLDrawable == null) || (!paramViewHolder.jdField_a_of_type_ComTencentImageURLDrawable.getURL().equals(tmp475_473)))
        {
          if (paramViewHolder.jdField_a_of_type_ComTencentImageURLDrawable != null) {
            QLog.d("tdrawable", 2, "holder.d=" + paramViewHolder.jdField_a_of_type_ComTencentImageURLDrawable.getURL() + "==url=" + tmp475_473);
          }
          localObject2 = a(this.jdField_a_of_type_AndroidContentContext, localMessageForPic, paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView, tmp479_475);
          paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable((Drawable)localObject2);
          paramViewHolder.jdField_a_of_type_ComTencentImageURLDrawable = ((URLDrawable)localObject2);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForPic, 2);
          paramView = (View)localObject2;
          if (QLog.isColorLevel())
          {
            QLog.d("PicItemBuilder", 2, "show receive pic uniseq=" + localMessageForPic.uniseq + " url=" + tmp475_473);
            paramView = (View)localObject2;
          }
          if (paramView == null) {
            QLog.d("tdrawable", 2, "d==null");
          }
          if (paramView == null) {
            break label1193;
          }
          paramView = paramView.getURL().getProtocol();
          if (QLog.isColorLevel()) {
            QLog.d("big_thumb", 2, "getview protocol=" + paramView + "isDynamic=" + bool + "thumbWidth=" + localMessageForPic.thumbWidth + "thumbHeight=" + localMessageForPic.thumbHeight);
          }
          long l1 = System.currentTimeMillis();
          if (!a(this.jdField_a_of_type_AndroidContentContext, bool, paramView.equals("chatthumb"), tmp479_475[0], tmp479_475[1], tmp475_473)) {
            break label1182;
          }
          paramViewHolder.jdField_a_of_type_ComTencentImageURLDrawable.setWatermarkDrawable(a(), AIOUtils.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          paramViewHolder.jdField_a_of_type_ComTencentImageURLDrawable.setWatermarkVisibility(0);
          long l2 = System.currentTimeMillis();
          if (QLog.isColorLevel()) {
            QLog.d("big_thumb", 2, "getview setGifTag  costTime= " + (l2 - l1));
          }
          label873:
          a(localMessageForPic, paramViewHolder);
          if ((paramBaseChatItemLayout != null) && (!HotChatUtil.a(localMessageForPic)))
          {
            paramView = (DuiButtonImageView)paramBaseChatItemLayout.findViewById(2131361945);
            if (((paramChatMessage.extraflag != 32768) || (!paramChatMessage.isSendFromLocal())) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramChatMessage))) {
              break label1429;
            }
            k = 1;
            label939:
            if ((!paramChatMessage.isDui) || (k != 0) || (!DuiButtonImageView.jdField_a_of_type_Boolean)) {
              break label1694;
            }
            if (!paramChatMessage.isSend()) {
              break label1435;
            }
            if (paramView != null)
            {
              paramView.setVisibility(8);
              paramView.e();
            }
            label978:
            a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatItemLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, this);
            paramView = LightReplyMenuManager.a();
            if (((this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity)) || (!a(this.jdField_a_of_type_AndroidContentContext)) || (paramView == null) || (!paramView.d()) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) || (localMessageForPic.isSend()) || (localMessageForPic.isDui)) {
              break label1725;
            }
            if (!bool) {
              break label1711;
            }
            a(paramBaseChatItemLayout, localMessageForPic, paramOnLongClickAndTouchListener, paramViewHolder, false);
            label1074:
            if (QLog.isColorLevel()) {
              QLog.e("zivonchen", 2, "PicItemBuilder getBubbleView isDynamic = " + bool);
            }
          }
        }
      }
      for (;;)
      {
        if (!((TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(202)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage)) {
          break label1733;
        }
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(true, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        return localObject1;
        paramView = paramViewHolder.jdField_a_of_type_ComTencentImageURLDrawable;
        tmp479_475[0] = paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getWidth();
        tmp479_475[1] = paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getHeight();
        break;
        label1182:
        paramViewHolder.jdField_a_of_type_ComTencentImageURLDrawable.setWatermarkVisibility(4);
        break label873;
        label1193:
        paramViewHolder.jdField_a_of_type_ComTencentImageURLDrawable.setWatermarkVisibility(4);
        QLog.d("tdrawable", 2, "not isDynamic tag gone");
        break label873;
        if (paramViewHolder.jdField_a_of_type_ComTencentImageURLDrawable != null) {
          paramViewHolder.jdField_a_of_type_ComTencentImageURLDrawable.setWatermarkVisibility(4);
        }
        paramView = a(localMessageForPic);
        if ((paramViewHolder.jdField_a_of_type_ComTencentImageURLDrawable == null) || (!paramViewHolder.jdField_a_of_type_ComTencentImageURLDrawable.getURL().equals(paramView)))
        {
          localObject2 = a(this.jdField_a_of_type_AndroidContentContext, localMessageForPic, paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView);
          paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable((Drawable)localObject2);
          paramViewHolder.jdField_a_of_type_ComTencentImageURLDrawable = ((URLDrawable)localObject2);
          if (bool)
          {
            if (QLog.isColorLevel()) {
              QLog.d("PicItemBuilder", 2, "predownloadDynamic pic uniseq=" + localMessageForPic.uniseq + " url=" + paramView);
            }
            a(localMessageForPic, paramViewHolder.jdField_a_of_type_ComTencentImageURLDrawable);
          }
          if (QLog.isColorLevel()) {
            QLog.d("PicItemBuilder", 2, "show send pic uniseq=" + localMessageForPic.uniseq + " url=" + paramView);
          }
        }
        paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForPic.frienduin, localMessageForPic.uniseq);
        paramViewHolder.jdField_a_of_type_AndroidViewView = ((View)localObject1);
        a(paramView, paramViewHolder);
        break label873;
        label1429:
        k = 0;
        break label939;
        label1435:
        if (paramView == null)
        {
          paramView = new DuiButtonImageView(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
          localObject2 = new RelativeLayout.LayoutParams(AIOUtils.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          ((RelativeLayout.LayoutParams)localObject2).addRule(8, 2131361877);
          ((RelativeLayout.LayoutParams)localObject2).addRule(1, 2131361877);
          ((RelativeLayout.LayoutParams)localObject2).bottomMargin = (BaseChatItemLayout.h - AIOUtils.a(6.5F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          paramView.setId(2131361945);
          paramBaseChatItemLayout.addView(paramView, (ViewGroup.LayoutParams)localObject2);
          if (QLog.isColorLevel()) {
            QLog.d("PicItemBuilder", 2, "message.hasPlayedDui = " + paramChatMessage.hasPlayedDui);
          }
          if (QLog.isColorLevel()) {
            QLog.d("[Doutu]CustomFrameAnimationDrawable", 2, " message.isDui = " + paramChatMessage.isDui + ", message.hasPlayedDui = " + paramChatMessage.hasPlayedDui);
          }
          if (paramChatMessage.hasPlayedDui) {
            break label1673;
          }
          paramChatMessage.hasPlayedDui = DuiButtonImageView.a(paramView);
        }
        for (;;)
        {
          label1547:
          if (!DuiButtonImageView.jdField_a_of_type_Boolean) {
            break label1680;
          }
          paramView.setOnClickListener(this);
          paramView.setVisibility(0);
          break;
          paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
          break label1547;
          label1673:
          paramView.f();
        }
        label1680:
        paramView.setOnClickListener(null);
        paramView.setVisibility(8);
        break label978;
        label1694:
        if (paramView == null) {
          break label978;
        }
        paramView.setVisibility(8);
        paramView.e();
        break label978;
        label1711:
        b(paramBaseChatItemLayout, localMessageForPic, paramOnLongClickAndTouchListener, paramViewHolder);
        break label1074;
        label1725:
        a(paramViewHolder);
      }
      label1733:
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(false, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return localObject1;
    }
  }
  
  public BaseBubbleBuilder.TouchDelegate a(View paramView)
  {
    if (paramView != null)
    {
      if (paramView.getId() == 2131361956) {
        return this;
      }
      if (paramView.getParent() != null)
      {
        paramView = (PicItemBuilder.Holder)((View)paramView.getParent()).getTag();
        if (paramView != null) {
          return paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView;
        }
      }
    }
    return null;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new PicItemBuilder.Holder(this);
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    if (MsgUtils.a(paramChatMessage.issend)) {
      return "发出图片";
    }
    return "发来图片";
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    MessageForPic localMessageForPic;
    String str;
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForPic)))
    {
      localMessageForPic = (MessageForPic)paramChatMessage;
      if (paramInt != 2131363536) {
        break label1022;
      }
      paramContext = new Bundle();
      paramContext.putInt("forward_type", 1);
      paramContext.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      paramChatMessage = new Intent();
      paramChatMessage.putExtra("forward_image_width", localMessageForPic.width);
      paramChatMessage.putExtra("forward_image_height", localMessageForPic.height);
      paramChatMessage.putExtra("forward_file_size", localMessageForPic.size);
      paramChatMessage.putExtra("forward_image_type", localMessageForPic.imageType);
      paramChatMessage.putExtra("forward_filepath", localMessageForPic.path);
      str = localMessageForPic.frienduin + localMessageForPic.uniseq + localMessageForPic.istroop;
      paramChatMessage.putExtra("BUSI_TYPE", 1009);
      paramChatMessage.putExtra("forward_download_image_task_key", str);
      paramChatMessage.putExtra("forward_download_image_org_uin", localMessageForPic.frienduin);
      paramChatMessage.putExtra("forward_download_image_org_uin_type", localMessageForPic.istroop);
      paramChatMessage.putExtra("forward_download_image_server_path", localMessageForPic.uuid);
      paramChatMessage.putExtra("forward_download_image_item_id", localMessageForPic.uniseq);
      paramChatMessage.putExtra("forward_photo_isSend", localMessageForPic.issend);
      paramChatMessage.putExtra("forward_photo_md5", localMessageForPic.md5);
      paramChatMessage.putExtra("forward_photo_group_fileid", localMessageForPic.groupFileID);
      paramChatMessage.putExtra("FORWARD_PHOTO_FILE_SIZE_FLAG", localMessageForPic.fileSizeFlag);
      paramChatMessage.putExtras(paramContext);
      if ((!ActionMsgUtil.a(localMessageForPic.msgtype)) && (localMessageForPic.msgtype != -3001) && (localMessageForPic.msgtype != -30002) && (localMessageForPic.msgtype != -30003)) {
        break label879;
      }
      paramInt = 1;
      if (paramInt != 0) {
        break label884;
      }
      paramInt = 65537;
      label347:
      paramContext = URLDrawableHelper.a(localMessageForPic, paramInt);
      if ((AbsDownloader.a(paramContext.toString()) != null) || (!localMessageForPic.isSendFromLocal()) || (!HotPicHelper.a(localMessageForPic))) {
        break label1664;
      }
      paramContext = localMessageForPic.getPicUploadInfo();
      paramContext.f = localMessageForPic.getExtInfoFromExtStr("hot_pic_thumb_md5");
      paramContext = URLDrawableHelper.a(paramContext, paramInt, null);
    }
    label1664:
    for (;;)
    {
      paramChatMessage.putExtra("forward_urldrawable", true);
      paramChatMessage.putExtra("forward_urldrawable_thumb_url", paramContext.toString());
      paramChatMessage.putExtra("FORWARD_URL_KEY", localMessageForPic.localUUID);
      paramContext = ForwardUtils.a(this.jdField_a_of_type_AndroidContentContext, localMessageForPic);
      paramChatMessage.putExtra("forward_urldrawable_big_url", paramContext.getURL().toString());
      paramChatMessage.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
      paramChatMessage.putExtra("PhotoConst.MY_UIN", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      paramChatMessage.putExtra("PhotoConst.MY_NICK", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname());
      if ((((this.jdField_a_of_type_AndroidContentContext instanceof SplashActivity)) || ((this.jdField_a_of_type_AndroidContentContext instanceof ChatActivity))) && (((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment() != null)) {
        paramChatMessage.putExtra("isBack2Root", ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().i);
      }
      paramChatMessage.putExtra("is_anonymous", AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      if ((this.jdField_a_of_type_AndroidContentContext instanceof SplashActivity))
      {
        paramChatMessage.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
        paramChatMessage = AIOUtils.a(paramChatMessage, null);
        label616:
        paramChatMessage.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        paramChatMessage.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
        paramChatMessage.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        paramChatMessage.putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", true);
        paramChatMessage.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1009);
        paramChatMessage.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
        paramChatMessage.putExtra("key_confess_topicid", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e);
        paramChatMessage.addFlags(603979776);
        paramChatMessage.putExtra("FORWARD_MSG_FOR_PIC", localMessageForPic);
        if (!new File(localMessageForPic.path).exists()) {
          break label906;
        }
        paramChatMessage.putExtra("forward_extra", localMessageForPic.path);
        paramChatMessage.putExtra("direct_send_if_dataline_forward", true);
        paramChatMessage.putExtra("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        if (localMessageForPic.picExtraData != null)
        {
          if (!localMessageForPic.picExtraData.isCustomFace()) {
            break label999;
          }
          paramChatMessage.putExtra("forward_is_custom_face", true);
          paramChatMessage.putExtra("forward_cutsom_face_type", localMessageForPic.picExtraData.customFaceType);
          paramChatMessage.putExtra("forward_diy_package_id", localMessageForPic.picExtraData.emojiPkgId);
        }
        label829:
        ForwardBaseOption.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramChatMessage, 21);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "3", "", "", "");
      }
      label879:
      label884:
      label1022:
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              paramInt = 0;
              break;
              paramInt = 1;
              break label347;
              paramChatMessage.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
              break label616;
              str = null;
              paramContext = paramContext.getURL().toString();
              File localFile;
              if (AbsDownloader.a(paramContext))
              {
                localFile = AbsDownloader.a(paramContext);
                paramContext = str;
                if (localFile != null) {
                  paramContext = localFile.getAbsolutePath();
                }
              }
              for (;;)
              {
                paramChatMessage.putExtra("forward_extra", paramContext);
                break;
                localFile = AbsDownloader.a(URLDrawableHelper.a(localMessageForPic, 65537).toString());
                paramContext = str;
                if (localFile != null)
                {
                  paramContext = str;
                  if (localFile.exists()) {
                    paramContext = localFile.getAbsolutePath();
                  }
                }
              }
              if (!localMessageForPic.picExtraData.isHotPics()) {
                break label829;
              }
              paramChatMessage.putExtra("HOT_PIC_HAS_EXTRA", true);
              break label829;
              if (paramInt == 2131361852)
              {
                paramContext = URLDrawableHelper.a(URLDrawableHelper.a(localMessageForPic, 1), -1, -1, null, null, false);
                paramContext.setTag(localMessageForPic);
                AIOGalleryUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext, localMessageForPic.frienduin, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448), null, localMessageForPic.picExtraData);
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006448", "0X8006448", 0, 0, "3", "", "", "");
                return;
              }
              if (paramInt == 2131375633)
              {
                ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006447", "0X8006447", 0, 0, "3", "", "", "");
                return;
              }
              if (paramInt == 2131375643)
              {
                super.c(paramChatMessage);
                return;
              }
              if (paramInt == 2131375637)
              {
                a(localMessageForPic);
                return;
              }
              if (paramInt == 2131366774)
              {
                QfavBuilder.a(localMessageForPic).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
                QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 3);
                return;
              }
              if (paramInt == 2131375635)
              {
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq);
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
                b();
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800409A", "0X800409A", 0, 0, "", "", "", "");
                return;
              }
              if (paramInt == 2131375636)
              {
                paramContext = new vhp(this);
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramContext);
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800409B", "0X800409B", 0, 0, "", "", "", "");
                return;
              }
              if (paramInt == 2131375642)
              {
                super.c(paramChatMessage);
                return;
              }
              if (paramInt == 2131361906)
              {
                super.a(paramChatMessage);
                return;
              }
              if (paramInt != 2131375651) {
                break label1656;
              }
            } while (paramChatMessage.istroop != 1);
            paramContext = localMessageForPic.getPicDownloadInfo();
            PicBusiManager.a(6, 1536, 1).a(localMessageForPic, paramContext);
            paramContext = AbsDownloader.d(URLDrawableHelper.a(localMessageForPic, 1, null).toString().toString());
            if (!FileUtils.a(paramContext)) {
              break label1604;
            }
            paramChatMessage = (TroopTopicMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(97);
          } while ((paramChatMessage == null) || (!(this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity)));
          paramChatMessage.a(((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localMessageForPic, paramContext, 4);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_talk", "", "pub_talk", "Clk_bubble", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "2", "", "");
        } while (!QLog.isColorLevel());
        QLog.d("PicItemBuilder", 2, "image has downloaded!");
        return;
        paramContext = AIOGalleryUtils.a(localMessageForPic);
      } while (paramContext == null);
      label906:
      label999:
      paramChatMessage = new WeakReference(new vhq(this, paramContext, localMessageForPic));
      label1604:
      TroopTopicMgr.a(localMessageForPic, paramContext.g, paramContext.f, 2, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      return;
      label1656:
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
  }
  
  public void a(int paramInt1, String paramString, long paramLong, int paramInt2, LightReplyEmojs paramLightReplyEmojs)
  {
    Object localObject = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
    if (localObject == null) {}
    for (localObject = null;; localObject = ((ChatFragment)localObject).a())
    {
      if (localObject != null) {
        ((BaseChatPie)localObject).a(this.jdField_a_of_type_AndroidContentContext, paramInt1, paramString, paramLong, paramInt2, paramLightReplyEmojs);
      }
      return;
    }
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    if (AIOUtils.a(paramView).isMultiMsg) {}
    do
    {
      return;
      paramView = (MessageForPic)((PicItemBuilder.Holder)AIOUtils.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    } while (!paramView.isSendFromLocal());
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
    localActionSheet.a(2131433649, 5);
    localActionSheet.c(2131433029);
    localActionSheet.a(new vhr(this, paramView, localActionSheet));
    localActionSheet.show();
  }
  
  public void a(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        return;
        if (paramMotionEvent.getAction() != 0) {
          break;
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager == null);
      this.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager.e();
      this.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager.a = new WeakReference(paramView);
      paramView.setAlpha(0.5F);
      return;
    } while (paramMotionEvent.getAction() != 3);
    paramView.setAlpha(1.0F);
  }
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    paramView = (PicItemBuilder.Holder)AIOUtils.a(paramView);
    if (paramView == null) {
      QLog.e("PicItemBuilder", 2, "handleMessage(): holder is null");
    }
    label183:
    label456:
    label458:
    label478:
    for (;;)
    {
      return;
      MessageForPic localMessageForPic = (MessageForPic)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null)
      {
        QLog.e("PicItemBuilder", 2, "handleMessage(): holder.mMessage is null");
        return;
      }
      if ((paramInt1 == 2003) && (paramFileMsg.jdField_b_of_type_Int == 65537))
      {
        boolean bool = PeakUtils.a(localMessageForPic.imageType);
        int k = paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getWidth();
        int m = paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getHeight();
        String str = paramView.jdField_a_of_type_ComTencentImageURLDrawable.getURL().getProtocol();
        URL localURL = URLDrawableHelper.a(localMessageForPic, 65537);
        if (a(this.jdField_a_of_type_AndroidContentContext, bool, str.equals("chatthumb"), k, m, localURL))
        {
          paramView.jdField_a_of_type_ComTencentImageURLDrawable.setWatermarkDrawable(a(), AIOUtils.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          paramView.jdField_a_of_type_ComTencentImageURLDrawable.setWatermarkVisibility(0);
        }
      }
      else
      {
        if (((paramFileMsg.jdField_b_of_type_Int != 1) && (paramFileMsg.jdField_b_of_type_Int != 131075)) || (paramInt1 == 2002) || (paramInt1 == 2001)) {
          break label456;
        }
        if ((paramInt1 != 1001) && (paramInt1 != 1000) && (paramInt1 != 4001) && (paramInt1 != 1002) && (paramInt1 != 1004) && (paramInt1 != 1005)) {
          break label458;
        }
      }
      for (this.h = false;; this.h = true) {
        do
        {
          if (localMessageForPic.uniseq != paramFileMsg.jdField_b_of_type_Long) {
            break label478;
          }
          a(localMessageForPic, "transf.in", "status:" + paramInt1 + ",retCode" + paramInt2 + "message.uniseq：" + localMessageForPic.uniseq + ",file.uniseq:" + paramFileMsg.jdField_b_of_type_Long);
          if (localMessageForPic.isSendFromLocal())
          {
            a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForPic.frienduin, localMessageForPic.uniseq), paramView);
            if (paramInt1 == 1005) {
              b();
            }
          }
          if (paramInt1 != 2003) {
            break;
          }
          a(localMessageForPic, paramView);
          paramFileMsg = a(this.jdField_a_of_type_AndroidContentContext, (MessageForPic)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView);
          paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramFileMsg);
          paramView.jdField_a_of_type_ComTencentImageURLDrawable = paramFileMsg;
          if (paramView.jdField_a_of_type_ComTencentImageURLDrawable == null) {
            break;
          }
          paramView.jdField_a_of_type_ComTencentImageURLDrawable.setWatermarkVisibility(4);
          return;
          paramView.jdField_a_of_type_ComTencentImageURLDrawable.setWatermarkVisibility(4);
          break label183;
          break;
        } while ((paramInt1 != 1007) && (paramInt1 != 1003));
      }
    }
  }
  
  public void a(View paramView, boolean paramBoolean) {}
  
  public void a(BaseChatItemLayout paramBaseChatItemLayout, MessageForPic paramMessageForPic, OnLongClickAndTouchListener paramOnLongClickAndTouchListener, PicItemBuilder.Holder paramHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.e("zivonchen", 2, "PicItemBuilder getBubbleView width = " + paramMessageForPic.width + ", height = " + paramMessageForPic.height);
    }
    ThreadManager.post(new vht(this, paramMessageForPic, paramBaseChatItemLayout, paramOnLongClickAndTouchListener, paramHolder), 10, null, false);
  }
  
  public void a(BaseChatItemLayout paramBaseChatItemLayout, MessageForPic paramMessageForPic, OnLongClickAndTouchListener paramOnLongClickAndTouchListener, PicItemBuilder.Holder paramHolder, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.e("zivonchen", 2, "PicItemBuilder realAddLightReplyBtn------------");
    }
    if (paramBaseChatItemLayout == null) {
      if (QLog.isColorLevel()) {
        QLog.e("zivonchen", 2, "PicItemBuilder realAddLightReplyBtn convertView is null!!!");
      }
    }
    ImageView localImageView;
    do
    {
      return;
      localImageView = (ImageView)paramBaseChatItemLayout.findViewById(2131361956);
      if (paramBoolean)
      {
        if (localImageView == null)
        {
          localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          localImageView.setImageResource(2130841470);
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.a(36.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(28.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          localLayoutParams.addRule(8, 2131361877);
          localLayoutParams.addRule(1, 2131361877);
          localLayoutParams.bottomMargin = (BaseChatItemLayout.h - AIOUtils.a(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          localLayoutParams.leftMargin = (0 - AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          localImageView.setId(2131361956);
          paramBaseChatItemLayout.addView(localImageView, localLayoutParams);
        }
        for (paramBaseChatItemLayout = localImageView;; paramBaseChatItemLayout = localImageView)
        {
          if (paramHolder.jdField_a_of_type_Long != paramMessageForPic.shmsgseq)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_replyPic", "", "Grp_AIO", "exp_reply", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
            paramHolder.jdField_a_of_type_Long = paramMessageForPic.shmsgseq;
          }
          paramBaseChatItemLayout.setOnClickListener(this);
          paramBaseChatItemLayout.setOnTouchListener(paramOnLongClickAndTouchListener);
          paramHolder.b = paramBaseChatItemLayout;
          return;
          localImageView.setVisibility(0);
        }
      }
    } while (localImageView == null);
    localImageView.setVisibility(8);
    localImageView.setOnClickListener(null);
    localImageView.setOnTouchListener(null);
  }
  
  public void a(MessageForPic paramMessageForPic)
  {
    if (FileUtils.b(paramMessageForPic.path)) {
      b(paramMessageForPic);
    }
    for (;;)
    {
      b();
      return;
      if (paramMessageForPic.picExtraFlag == TranDbRecord.PicDbRecord.f) {
        c(paramMessageForPic);
      }
    }
  }
  
  void a(MessageForPic paramMessageForPic, URLDrawable paramURLDrawable)
  {
    if (!paramURLDrawable.getURL().getProtocol().equals("chatimg")) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramMessageForPic, 2);
    }
  }
  
  void a(MessageForPic paramMessageForPic, PicItemBuilder.Holder paramHolder)
  {
    if ((paramMessageForPic.picExtraData != null) && (paramMessageForPic.picExtraData.isDiyDouTu()))
    {
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      if (!a(paramMessageForPic))
      {
        paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837572);
        paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
  }
  
  protected boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    boolean bool = true;
    if (paramChatMessage.isMultiMsg) {}
    while (!paramChatMessage.isSendFromLocal()) {
      return false;
    }
    paramChatMessage = (MessageForPic)paramChatMessage;
    if (paramChatMessage.size <= 0L)
    {
      paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq);
      if ((paramChatMessage instanceof BaseTransProcessor))
      {
        long l = ((BaseTransProcessor)paramChatMessage).c();
        if ((l == 1005L) || ((l == 1006L) && (!this.g)) || (l == 1004L)) {}
        for (bool = true;; bool = false) {
          return bool;
        }
      }
      return true;
    }
    if (paramChatMessage.extraflag == 32768) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  boolean a(boolean paramBoolean, MessageForPic paramMessageForPic)
  {
    if (!paramBoolean)
    {
      PicUploadInfo localPicUploadInfo;
      if ((paramMessageForPic.isSendFromLocal()) && (HotPicHelper.a(paramMessageForPic)))
      {
        localPicUploadInfo = paramMessageForPic.getPicUploadInfo();
        localPicUploadInfo.f = paramMessageForPic.getExtInfoFromExtStr("hot_pic_thumb_md5");
        if (AbsDownloader.a(URLDrawableHelper.a(localPicUploadInfo, 65537, null).toString()) == null) {}
      }
      do
      {
        return true;
        return false;
        if (paramMessageForPic.getExtInfoFromExtStr("doutu_thumb_md5").equals("")) {
          break;
        }
        localPicUploadInfo = paramMessageForPic.getPicUploadInfo();
        localPicUploadInfo.f = paramMessageForPic.getExtInfoFromExtStr("doutu_thumb_md5");
      } while (AbsDownloader.a(URLDrawableHelper.a(localPicUploadInfo, 65537, null).toString()) != null);
      return false;
    }
    return paramBoolean;
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    Object localObject = (PicItemBuilder.Holder)AIOUtils.a(paramView);
    MessageForPic localMessageForPic = (MessageForPic)((PicItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    paramView = new QQCustomMenu();
    if (ConfessMsgUtil.a(localMessageForPic)) {
      return paramView.a();
    }
    boolean bool2 = URLDrawableHelper.a(this.jdField_a_of_type_AndroidContentContext, localMessageForPic, 65537);
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = bool2;
      if (localMessageForPic.isSendFromLocal()) {
        bool1 = a(bool2, localMessageForPic);
      }
    }
    int k;
    if (!TextUtils.isEmpty(localMessageForPic.getExtInfoFromExtStr("sticker_info")))
    {
      k = 1;
      this.g = true;
      if (localMessageForPic.isSendFromLocal()) {
        break label316;
      }
      if (((PicItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 1)
      {
        if (k != 0) {
          break label298;
        }
        if (AIOUtils.a(1) == 1) {
          paramView.a(2131361852, this.jdField_a_of_type_AndroidContentContext.getString(2131435889), 2130838316);
        }
        if (bool1)
        {
          paramView.a(2131363536, this.jdField_a_of_type_AndroidContentContext.getString(2131435099), 2130838318);
          if ((localMessageForPic.istroop == 1) && (AIOUtils.a(4) == 1)) {
            paramView.a(2131375651, this.jdField_a_of_type_AndroidContentContext.getString(2131430735), 2130838326);
          }
        }
        a(localMessageForPic, paramView);
        if (AIOUtils.a(5) == 1) {
          paramView.a(2131366774, this.jdField_a_of_type_AndroidContentContext.getString(2131431574), 2130838317);
        }
        a(paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageForPic);
        ChatActivityFacade.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        super.b(paramView, this.jdField_a_of_type_AndroidContentContext);
      }
    }
    for (;;)
    {
      return paramView.a();
      k = 0;
      break;
      label298:
      ChatActivityFacade.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    }
    label316:
    if (localMessageForPic.size > 0L) {
      if (k == 0)
      {
        if (AIOUtils.a(1) == 1) {
          paramView.a(2131361852, this.jdField_a_of_type_AndroidContentContext.getString(2131435889), 2130838316);
        }
        if (bool1)
        {
          paramView.a(2131363536, this.jdField_a_of_type_AndroidContentContext.getString(2131435099), 2130838318);
          if ((localMessageForPic.istroop == 1) && (AIOUtils.a(4) == 1)) {
            paramView.a(2131375651, this.jdField_a_of_type_AndroidContentContext.getString(2131430735), 2130838326);
          }
        }
        if (AIOUtils.a(5) == 1) {
          paramView.a(2131366774, this.jdField_a_of_type_AndroidContentContext.getString(2131431574), 2130838317);
        }
        if ((localMessageForPic.isSend()) && (localMessageForPic.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localMessageForPic))) {
          a(paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageForPic);
        }
        ChatActivityFacade.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        super.b(paramView, this.jdField_a_of_type_AndroidContentContext);
      }
    }
    for (;;)
    {
      return paramView.a();
      ChatActivityFacade.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      continue;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForPic.frienduin, localMessageForPic.uniseq);
      if ((localObject instanceof BaseTransProcessor))
      {
        localObject = (BaseTransProcessor)localObject;
        long l = ((BaseTransProcessor)localObject).c();
        if ((l == 1005L) || (l == 1006L) || (l == 1004L) || (((BaseTransProcessor)localObject).d() == 1003L))
        {
          if (k == 0)
          {
            if (AIOUtils.a(1) == 1) {
              paramView.a(2131361852, this.jdField_a_of_type_AndroidContentContext.getString(2131435889), 2130838316);
            }
            if (bool1) {
              paramView.a(2131363536, this.jdField_a_of_type_AndroidContentContext.getString(2131435099), 2130838318);
            }
            if (AIOUtils.a(5) == 1) {
              paramView.a(2131366774, this.jdField_a_of_type_AndroidContentContext.getString(2131431574), 2130838317);
            }
            ChatActivityFacade.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            super.b(paramView, this.jdField_a_of_type_AndroidContentContext);
          }
          else
          {
            ChatActivityFacade.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          }
        }
        else if (k == 0)
        {
          paramView.a(2131375635, this.jdField_a_of_type_AndroidContentContext.getString(2131433653), 2130838308);
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
            paramView.a(2131375636, this.jdField_a_of_type_AndroidContentContext.getString(2131433654), 2130838307);
          }
          this.i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        }
      }
      else if (k == 0)
      {
        if (AIOUtils.a(1) == 1) {
          paramView.a(2131361852, this.jdField_a_of_type_AndroidContentContext.getString(2131435889), 2130838316);
        }
        if (bool1) {
          paramView.a(2131363536, this.jdField_a_of_type_AndroidContentContext.getString(2131435099), 2130838318);
        }
        if (AIOUtils.a(5) == 1) {
          paramView.a(2131366774, this.jdField_a_of_type_AndroidContentContext.getString(2131431574), 2130838317);
        }
        ChatActivityFacade.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        super.b(paramView, this.jdField_a_of_type_AndroidContentContext);
      }
      else
      {
        ChatActivityFacade.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      }
    }
  }
  
  public void d()
  {
    super.d();
    if (this.i)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      this.i = false;
    }
    this.g = false;
  }
  
  public void onClick(View paramView)
  {
    AIOUtils.m = true;
    if (super.a()) {}
    int k;
    Object localObject1;
    do
    {
      do
      {
        return;
        k = paramView.getId();
        if (k != 2131361877) {
          break label472;
        }
        localObject1 = (PicItemBuilder.Holder)AIOUtils.a(paramView);
        paramView = (MessageForPic)((PicItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        localObject2 = ((PicItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentImageURLDrawable;
        if (paramView.isSendFromLocal()) {
          break;
        }
        switch (((URLDrawable)localObject2).getStatus())
        {
        default: 
          return;
        }
      } while (((URLDrawable)localObject2).isDownloadStarted());
      ((URLDrawable)localObject2).startDownload();
      return;
      if ((Utils.a()) && (Utils.b() < 20971520L))
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, "手机存储空间已满，请清理后重新进入QQ。", 0).a();
        return;
      }
    } while (!FileUtils.a(this.jdField_a_of_type_AndroidContentContext));
    ((URLDrawable)localObject2).restartDownload();
    return;
    Object localObject2 = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)) {
      ((TroopHandler)localObject2).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
    }
    if ((paramView.picExtraData != null) && (paramView.picExtraData.isDiyDouTu()))
    {
      if (a(paramView))
      {
        a(String.valueOf(paramView.picExtraData.emojiPkgId));
        return;
      }
      localObject1 = ((PicItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
      ((BaseChatItemLayout)localObject1).setProgressVisable(false);
      localObject2 = PicBusiManager.a(6, 1536, 1);
      ((PicReq)localObject2).a(paramView, paramView.getPicDownloadInfo());
      ((PicReq)localObject2).a(new vhn(this, (BaseChatItemLayout)localObject1));
      PicBusiManager.a((PicReq)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    if (!(this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity)) {}
    for (boolean bool = true;; bool = false)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, ((PicItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView, paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, bool);
      return;
    }
    if (((URLDrawable)localObject2).getStatus() == 2)
    {
      if ((Utils.a()) && (Utils.b() < 20971520L))
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, "手机存储空间已满，请清理后重试。", 0).a();
        return;
      }
      if (FileUtils.a(this.jdField_a_of_type_AndroidContentContext)) {
        ((URLDrawable)localObject2).restartDownload();
      }
    }
    if ((paramView.picExtraData != null) && (paramView.picExtraData.isDiyDouTu()))
    {
      a(String.valueOf(paramView.picExtraData.emojiPkgId));
      return;
    }
    if (!(this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity)) {}
    for (bool = true;; bool = false)
    {
      a(this.jdField_a_of_type_AndroidContentContext, ((PicItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView, paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, bool);
      return;
    }
    label472:
    Object localObject3;
    if (k == 2131361945)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PicItemBuilder", 2, "[Doutu] Dui Button Clicked.");
      }
      if (QLog.isColorLevel()) {
        QLog.d("PicItemBuilder", 2, "[Doutu] Dui Button Clicked.");
      }
      localObject1 = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
      if (localObject1 != null)
      {
        localObject2 = ((ChatFragment)localObject1).a();
        if (localObject2 != null)
        {
          localObject1 = null;
          localObject3 = (MessageForPic)((PicItemBuilder.Holder)AIOUtils.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
          if (localObject3 != null) {
            localObject1 = new DoutuItem(((MessageForPic)localObject3).uuid, ((MessageForPic)localObject3).md5, ((MessageForPic)localObject3).groupFileID, ((MessageForPic)localObject3).rawMsgUrl);
          }
          ((BaseChatPie)localObject2).a().obtainMessage(79, localObject1).sendToTarget();
        }
      }
    }
    do
    {
      for (;;)
      {
        super.onClick(paramView);
        return;
        if (QLog.isColorLevel())
        {
          QLog.d("PicItemBuilder", 2, "[Doutu] curPie is null.");
          continue;
          if (QLog.isColorLevel())
          {
            QLog.d("PicItemBuilder", 2, "[Doutu] chatFragment is null.");
            continue;
            if (k != 2131361860) {
              break;
            }
            localObject1 = (MessageRecord)paramView.getTag();
            if (localObject1 != null) {
              ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(216)).a(paramView.getContext(), (MessageRecord)localObject1);
            }
          }
        }
      }
    } while (k != 2131361956);
    if ((this.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager != null) && (this.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager.b()))
    {
      this.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager.a();
      this.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager.e();
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_replyPic", "", "Grp_AIO", "clk_reply", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
      break;
      if (LightReplyMenuManager.a().c())
      {
        localObject1 = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
        if (localObject1 != null)
        {
          localObject1 = ((ChatFragment)localObject1).a();
          if (localObject1 != null)
          {
            localObject3 = (PicItemBuilder.Holder)AIOUtils.a(paramView);
            localObject2 = ((PicItemBuilder.Holder)localObject3).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getDrawable();
            localObject3 = (MessageForPic)((PicItemBuilder.Holder)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
            int[] arrayOfInt = new int[2];
            paramView.getLocationOnScreen(arrayOfInt);
            k = arrayOfInt[1];
            int m = AIOUtils.a(58.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
            int n = ((WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window")).getDefaultDisplay().getWidth() / 2;
            if (this.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager != null) {
              this.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager.a(this.jdField_a_of_type_AndroidContentContext, ((BaseChatPie)localObject1).a(), ((MessageForPic)localObject3).istroop, ((MessageForPic)localObject3).frienduin, ((MessageForPic)localObject3).shmsgseq, ((MessageForPic)localObject3).subMsgId, (Drawable)localObject2, this, true, n, k - m);
            }
          }
        }
      }
      else
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, -1, "出错了，请稍后重试！", 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PicItemBuilder
 * JD-Core Version:    0.7.0.1
 */