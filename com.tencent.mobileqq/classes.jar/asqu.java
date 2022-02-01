import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.widget.EditText;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.SendPhotoTask;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.emosearch.EmotionSearchItem;
import com.tencent.mobileqq.hotpic.HotPicPageView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;

public class asqu
  extends asmu
{
  static long a;
  protected int a;
  public EmotionSearchItem a;
  protected String a;
  protected int b;
  
  public asqu(int paramInt1, int paramInt2, String paramString, EmotionSearchItem paramEmotionSearchItem)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqEmosmEmosearchEmotionSearchItem = paramEmotionSearchItem;
    this.b = paramInt2;
  }
  
  public Drawable a(Context paramContext, float paramFloat)
  {
    paramContext = URLDrawable.URLDrawableOptions.obtain();
    paramContext.mLoadingDrawable = HotPicPageView.a;
    paramContext.mFailedDrawable = HotPicPageView.a;
    paramContext.mPlayGifImage = true;
    paramContext.mExtraInfo = this.jdField_a_of_type_ComTencentMobileqqEmosmEmosearchEmotionSearchItem;
    URL localURL = avte.a(this.jdField_a_of_type_ComTencentMobileqqEmosmEmosearchEmotionSearchItem.url);
    if (localURL == null) {
      return null;
    }
    return URLDrawable.getDrawable(localURL, paramContext);
  }
  
  protected void a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      if (!bhsr.a(this.jdField_a_of_type_JavaLangString)) {
        bdll.b(paramQQAppInterface, "dc00898", "", "", "0X800AE2E", "0X800AE2E", 0, 0, this.b + "", "", this.jdField_a_of_type_ComTencentMobileqqEmosmEmosearchEmotionSearchItem.getEmoMd5(), "");
      }
      if (bhsr.a(this.jdField_a_of_type_JavaLangString))
      {
        i = 1;
        bdll.b(paramQQAppInterface, "dc00898", "", "", "0X800AE20", "0X800AE20", i, 0, this.b + "", "", this.jdField_a_of_type_ComTencentMobileqqEmosmEmosearchEmotionSearchItem.getEmoMd5(), "");
      }
    }
    while (this.jdField_a_of_type_Int != 2) {
      for (;;)
      {
        return;
        int i = 2;
      }
    }
    bdll.b(paramQQAppInterface, "dc00898", "", "", "0X800AE36", "0X800AE36", 0, 0, this.b + "", "", this.jdField_a_of_type_ComTencentMobileqqEmosmEmosearchEmotionSearchItem.getEmoMd5(), "");
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, EditText paramEditText, SessionInfo paramSessionInfo)
  {
    long l = System.currentTimeMillis();
    if (l - jdField_a_of_type_Long < 1000L) {
      if (QLog.isColorLevel()) {
        QLog.e("HotPicSearchEmoticonInfo", 2, "send to offen,please try it later");
      }
    }
    do
    {
      return;
      jdField_a_of_type_Long = l;
      if (((paramContext instanceof BaseActivity)) && (axug.a(paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString)))
      {
        paramContext = (BaseActivity)paramContext;
        QQToast.a(paramQQAppInterface.getApp(), anzj.a(2131700220), 0).b(paramContext.getTitleBarHeight());
        return;
      }
    } while (!(paramContext instanceof BaseActivity));
    int j = 0;
    paramEditText = null;
    Object localObject = avte.a(this.jdField_a_of_type_ComTencentMobileqqEmosmEmosearchEmotionSearchItem.originalUrl);
    int i;
    if ((localObject != null) && (bhmi.b(((File)localObject).getAbsolutePath())))
    {
      localObject = ((File)localObject).getAbsolutePath();
      j = 1;
      paramEditText = (EditText)localObject;
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("HotPicSearchEmoticonInfo", 2, "senHotPic, urlHotPicOringinal = " + this.jdField_a_of_type_ComTencentMobileqqEmosmEmosearchEmotionSearchItem.originalUrl + ", paths = " + (String)localObject);
        i = j;
        paramEditText = (EditText)localObject;
      }
    }
    while ((paramEditText == null) && (paramSessionInfo.jdField_a_of_type_Int != 1008))
    {
      QQToast.a(paramContext, 2131698129, 0).a();
      return;
      i = j;
      if (HotPicPageView.a(this.jdField_a_of_type_ComTencentMobileqqEmosmEmosearchEmotionSearchItem) == 0)
      {
        localObject = avte.a(this.jdField_a_of_type_ComTencentMobileqqEmosmEmosearchEmotionSearchItem.url).getAbsolutePath();
        paramEditText = (EditText)localObject;
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.d("HotPicSearchEmoticonInfo", 2, "senHotPic, urlHotPic = " + this.jdField_a_of_type_ComTencentMobileqqEmosmEmosearchEmotionSearchItem.url + ", paths = " + (String)localObject);
          paramEditText = (EditText)localObject;
          i = j;
        }
      }
    }
    a(paramQQAppInterface);
    paramQQAppInterface = new Intent();
    localObject = new ArrayList();
    ((ArrayList)localObject).add(paramEditText);
    paramQQAppInterface.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)localObject);
    paramQQAppInterface.putExtra("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
    paramQQAppInterface.putExtra("uintype", paramSessionInfo.jdField_a_of_type_Int);
    paramQQAppInterface.putExtra("troop_uin", paramSessionInfo.b);
    paramQQAppInterface.putExtra("key_confess_topicid", paramSessionInfo.e);
    paramQQAppInterface.putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
    paramQQAppInterface.putExtra("send_in_background", true);
    paramQQAppInterface.putExtra("PhotoConst.SINGLE_PHOTO_PATH", (Serializable)localObject);
    paramQQAppInterface.putExtra("PicContants.NEED_COMPRESS", false);
    if (i == 0)
    {
      paramQQAppInterface.putExtra("quick_send_original_md5", this.jdField_a_of_type_ComTencentMobileqqEmosmEmosearchEmotionSearchItem.originalMD5);
      paramQQAppInterface.putExtra("quick_send_original_size", this.jdField_a_of_type_ComTencentMobileqqEmosmEmosearchEmotionSearchItem.oringinalSize);
      paramQQAppInterface.putExtra("quick_send_thumb_md5", this.jdField_a_of_type_ComTencentMobileqqEmosmEmosearchEmotionSearchItem.md5);
      paramQQAppInterface.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1042);
    }
    for (;;)
    {
      ThreadManager.post(new SendPhotoTask((BaseActivity)paramContext, paramQQAppInterface, null), 8, null, false);
      return;
      paramQQAppInterface.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1031);
    }
  }
  
  public Drawable b(Context paramContext, float paramFloat)
  {
    return a(paramContext, paramFloat);
  }
  
  public String toString()
  {
    return String.format("HotPicSearchEmoticonInfo, SearchItem %s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqEmosmEmosearchEmotionSearchItem.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asqu
 * JD-Core Version:    0.7.0.1
 */