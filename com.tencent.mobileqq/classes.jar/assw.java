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
import com.tencent.mobileqq.hotpic.HotPicPageView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class assw
  extends asmu
{
  static long jdField_a_of_type_Long;
  public int a;
  public astj a;
  private String jdField_a_of_type_JavaLangString = "";
  public int b;
  private int h;
  
  public assw(astj paramastj, int paramInt)
  {
    this.jdField_a_of_type_Astj = paramastj;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public Drawable a(Context paramContext, float paramFloat)
  {
    paramContext = URLDrawable.URLDrawableOptions.obtain();
    paramContext.mLoadingDrawable = HotPicPageView.a;
    paramContext.mFailedDrawable = HotPicPageView.a;
    paramContext.mPlayGifImage = true;
    return URLDrawable.getDrawable(this.jdField_a_of_type_Astj.b, paramContext);
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
      Object localObject1 = null;
      Object localObject2 = beqz.a(this.jdField_a_of_type_Astj.b);
      paramEditText = (EditText)localObject1;
      if (localObject2 != null)
      {
        paramEditText = (EditText)localObject1;
        if (bhmi.b(((File)localObject2).getAbsolutePath()))
        {
          localObject1 = ((File)localObject2).getAbsolutePath();
          paramEditText = (EditText)localObject1;
          if (QLog.isColorLevel())
          {
            QLog.d("HotPicSearchEmoticonInfo", 2, "senHotPic, urlHotPicOringinal = " + this.jdField_a_of_type_Astj.b + ", paths = " + (String)localObject1);
            paramEditText = (EditText)localObject1;
          }
        }
      }
      if ((paramEditText == null) && (paramSessionInfo.jdField_a_of_type_Int != 1008))
      {
        QQToast.a(paramContext, 2131698129, 0).a();
        return;
      }
      localObject1 = new Intent();
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(paramEditText);
      ((Intent)localObject1).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)localObject2);
      ((Intent)localObject1).putExtra("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
      ((Intent)localObject1).putExtra("uintype", paramSessionInfo.jdField_a_of_type_Int);
      ((Intent)localObject1).putExtra("troop_uin", paramSessionInfo.b);
      ((Intent)localObject1).putExtra("key_confess_topicid", paramSessionInfo.e);
      ((Intent)localObject1).putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
      ((Intent)localObject1).putExtra("send_in_background", true);
      ((Intent)localObject1).putExtra("PhotoConst.SINGLE_PHOTO_PATH", (Serializable)localObject2);
      ((Intent)localObject1).putExtra("PicContants.NEED_COMPRESS", false);
      ((Intent)localObject1).putExtra("quick_send_original_md5", this.jdField_a_of_type_Astj.jdField_a_of_type_JavaLangString);
      ((Intent)localObject1).putExtra("quick_send_original_size", this.jdField_a_of_type_Astj.jdField_a_of_type_Long);
      ((Intent)localObject1).putExtra("HOT_PIC_HAS_EXTRA", true);
      ((Intent)localObject1).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1054);
      ThreadManager.post(new SendPhotoTask((BaseActivity)paramContext, (Intent)localObject1, null), 8, null, false);
      bdll.b(paramQQAppInterface, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800B117", "0X800B117", asos.a(this.h), 0, "", this.b + 1 + "", this.jdField_a_of_type_Astj.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Astj.b);
    } while (this.jdField_a_of_type_Int <= 0);
    bdll.b(paramQQAppInterface, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800B11E", "0X800B11E", this.jdField_a_of_type_Int, 0, "", this.b + 1 + "", this.jdField_a_of_type_Astj.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Astj.b);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.h = paramInt1;
    this.b = paramInt2;
  }
  
  public Drawable b(Context paramContext, float paramFloat)
  {
    return a(paramContext, paramFloat);
  }
  
  public String toString()
  {
    return String.format("RelatedEmoSearchEmoticonInfo, SearchItem %s", new Object[] { this.jdField_a_of_type_Astj.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     assw
 * JD-Core Version:    0.7.0.1
 */