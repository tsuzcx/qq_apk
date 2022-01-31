import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import java.util.ArrayList;

public class axzh
{
  public static void a(Activity paramActivity, int paramInt1, String paramString1, String paramString2, long paramLong1, long paramLong2, int paramInt2, boolean paramBoolean)
  {
    if (paramActivity == null) {
      return;
    }
    Object localObject = paramActivity.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    BrowserLogHelper.getInstance().getGalleryLog().d("GalleryJumpUtils", 4, "jumpToTargetAIOPosition, className = " + (String)localObject + ", time = " + paramLong1 + " , shmsgseq = " + paramLong2 + ", isEmotion = " + paramBoolean);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("need_jump_to_msg", true);
    localBundle.putLong("searched_timeorseq", paramLong2);
    localBundle.putLong("searched_time", paramLong1);
    localBundle.putLong("target_shmsgseq", paramLong2);
    localBundle.putBoolean("searched_update_session", true);
    localBundle.putBoolean("jump_from_shmsgseq", true);
    Intent localIntent = new Intent();
    int i;
    boolean bool1;
    label193:
    boolean bool3;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localIntent.setClassName(paramActivity, (String)localObject);
      i = paramActivity.getIntent().getIntExtra("extra.EXTRA_ENTRANCE", -1);
      if ((i != 2) && (i != 3)) {
        break label375;
      }
      bool1 = true;
      bool3 = paramActivity.getIntent().getBooleanExtra("from_chat_history", false);
      if (!paramBoolean) {
        break label381;
      }
    }
    label375:
    label381:
    for (boolean bool2 = bool3;; bool2 = bool1)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("GalleryJumpUtils", 4, "jumpToTargetAIOPosition, isFromHistory = " + bool2 + ", isEmotion = " + paramBoolean + ", sourceEntrance = " + i + ", fromHistory_picAndVideo = " + bool1 + ", fromHistory_emotion = " + bool3);
      if (!bool2) {
        break label423;
      }
      paramInt1 = paramActivity.getIntent().getIntExtra("FromChatHistoryTab", 0);
      BrowserLogHelper.getInstance().getGalleryLog().d("GalleryJumpUtils", 4, "jumpToTargetAIOPosition, fromType = " + paramInt1);
      if ((paramInt1 != 2) && (paramInt1 != 4)) {
        break label403;
      }
      if (paramInt2 != 1) {
        break label388;
      }
      ChatHistoryBubbleListForTroopFragment.a(paramActivity, paramString2, paramLong2, -1, 0);
      return;
      localIntent.setClass(paramActivity, SplashActivity.class);
      break;
      bool1 = false;
      break label193;
    }
    label388:
    ChatHistoryActivity.a(paramActivity, paramString1, paramInt2, "", paramLong1, paramLong2, 0);
    return;
    label403:
    localIntent.putExtras(localBundle);
    paramActivity.setResult(-1, localIntent);
    paramActivity.finish();
    return;
    label423:
    localObject = aepi.a(localIntent, null);
    ((Intent)localObject).putExtras(localBundle);
    ((Intent)localObject).putExtra("uin", paramString1);
    ((Intent)localObject).putExtra("uintype", paramInt1);
    ((Intent)localObject).putExtra("troop_uin", paramString2);
    ((Intent)localObject).addFlags(603979776);
    ((Intent)localObject).putExtra("entrance", 1);
    paramActivity.startActivity((Intent)localObject);
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle)
  {
    Intent localIntent = aepi.a(new Intent(paramActivity, SplashActivity.class), null);
    paramBundle = new Bundle(paramBundle);
    BrowserLogHelper.getInstance().getGalleryLog().d("GalleryJumpUtils", 4, "AIOGallerysence startChatAndSendMsg IS_WAIT_DEST_RESULT=true");
    paramBundle.putBoolean("PhotoConst.HANDLE_DEST_RESULT", true);
    paramBundle.putBoolean("PhotoConst.IS_FORWARD", true);
    paramBundle.putInt("PhotoConst.SEND_BUSINESS_TYPE", 1031);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("extra_image_sender_tag", "sessionInfo.aioAlbum");
    paramBundle.putBoolean("PicContants.NEED_COMPRESS", false);
    localIntent.putExtras(paramBundle);
    String str = paramBundle.getString("GALLERY.FORWORD_LOCAL_PATH");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(str);
    PhotoUtils.a(paramActivity, localIntent, localArrayList, paramBundle.getInt("PhotoConst.SEND_SIZE_SPEC", 0), true);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    Intent localIntent = new Intent(paramContext, ChatHistoryActivity.class);
    localIntent.addFlags(536870912);
    localIntent.putExtra("tab_tab_type", 0);
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("SissionUin", paramString);
    localIntent.putExtra("uintype", paramInt);
    localIntent.putExtra("extra.IS_FROM_CHAT_AIO_GALLERY", true);
    localIntent.putExtra("extra.EXTRA_CURRENT_IMAGE", axzf.a((AIOBrowserBaseData)paramRichMediaBrowserInfo.baseData));
    localIntent.putExtra("leftViewText", paramContext.getString(2131690885));
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt1, boolean paramBoolean, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, String paramString7, Intent paramIntent)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.setClass(paramContext, ScannerActivity.class);
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString1);
    localIntent.putExtra("detectType", paramInt2);
    localIntent.putExtra("QRDecode", true);
    localIntent.putExtra("QRDecodeResult", paramString1);
    paramString1 = null;
    paramIntent = null;
    paramInt2 = 0;
    switch (paramInt1)
    {
    default: 
      if (paramBoolean) {
        paramInt1 = 3;
      }
      break;
    }
    for (;;)
    {
      try
      {
        if (!TextUtils.equals(paramString2, paramString6)) {
          continue;
        }
        paramString6 = paramString7;
        if (TextUtils.isEmpty(paramString4)) {
          continue;
        }
        int i = bara.d();
        if (paramInt2 == 0) {
          continue;
        }
        paramString7 = "gchat.qpic.cn";
        if (TextUtils.isEmpty(paramString7)) {
          continue;
        }
        if (i == 80) {
          continue;
        }
        paramString1 = paramString7 + ":" + i + paramString4;
      }
      catch (Throwable paramString1)
      {
        BrowserLogHelper.getInstance().getGalleryLog().d("GalleryJumpUtils", 4, "onQRDecodeSucceed error:" + paramString1.getMessage());
        continue;
        continue;
        paramString1 = null;
        continue;
        paramString1 = null;
        continue;
        paramString1 = null;
        continue;
      }
      localIntent.putExtra("report_params", yak.a(paramString3, paramString1, paramString5, paramString2, paramString6, paramInt1));
      paramContext.startActivity(localIntent);
      return;
      if (paramBoolean)
      {
        paramInt1 = 4;
        paramString6 = paramIntent;
      }
      else
      {
        paramInt1 = 2;
        paramInt2 = 1;
        paramString6 = paramIntent;
        continue;
        paramInt1 = 1;
        continue;
        continue;
        paramString7 = "c2cpicdw.qpic.cn";
        continue;
        paramString1 = paramString7 + paramString4;
        continue;
        if (TextUtils.isEmpty(paramString5)) {
          continue;
        }
        switch (paramInt1)
        {
        case 2: 
          paramString1 = "gchat.qpic.cn/gchatpic_new";
          if (!TextUtils.isEmpty(paramString2)) {
            paramString1 = "gchat.qpic.cn/gchatpic_new" + "/" + paramString2;
          }
          if (paramString5.startsWith("/")) {
            paramString1 = paramString1 + "0-0-" + paramString5.replace(".jpg", "") + "/0";
          } else {
            paramString1 = paramString1 + "/0-0-" + paramString5.replace(".jpg", "") + "/0";
          }
          break;
        case 1: 
          paramString1 = "c2cpicdw.qpic.cn/offpic_new";
          if (!TextUtils.isEmpty(paramString2)) {
            paramString1 = "c2cpicdw.qpic.cn/offpic_new" + "/" + paramString2;
          }
          if (paramString5.startsWith("/")) {
            paramString1 = paramString1 + paramString5 + "/0";
          } else {
            paramString1 = paramString1 + "/" + paramString5 + "/0";
          }
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axzh
 * JD-Core Version:    0.7.0.1
 */