import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.widget.EditText;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

public class apud
  extends appw
{
  public int a;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable();
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public Emoticon a;
  private String jdField_a_of_type_JavaLangString = "SmallEmoticonInfo";
  private int jdField_b_of_type_Int;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private String jdField_b_of_type_JavaLangString;
  public boolean b;
  private int h;
  
  public apud(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "currentAccountUin:" + paramString);
    }
    this.jdField_b_of_type_JavaLangString = paramString;
    if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) || (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null)) {}
    try
    {
      paramString = BaseApplication.getContext().getResources();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramString.getDrawable(2130837906);
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramString.getDrawable(2130843327);
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(this.jdField_a_of_type_JavaLangString, 2, paramString.getMessage());
      return;
    }
    catch (OutOfMemoryError paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(this.jdField_a_of_type_JavaLangString, 2, paramString.getMessage());
    }
  }
  
  public Drawable a(Context paramContext, float paramFloat)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon != null) {
      try
      {
        paramContext = new URL("emotion_pic", "fromPanel", a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon));
        paramContext = URLDrawable.getDrawable(paramContext, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, false);
        paramContext.setTag(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
        paramContext.addHeader("my_uin", this.jdField_b_of_type_JavaLangString);
        return paramContext;
      }
      catch (MalformedURLException paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "getDrawable ,", paramContext);
        }
        return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      }
    }
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public String a(Emoticon paramEmoticon)
  {
    if (paramEmoticon == null) {
      return null;
    }
    return paramEmoticon.epId + "_" + paramEmoticon.eId;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, EditText paramEditText, SessionInfo paramSessionInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null)
    {
      bdqr.a("emotionType", "emotionActionSend", "1", "", "", "", "", "", "", "");
      QLog.e(this.jdField_a_of_type_JavaLangString, 1, "fail to send small_emotion.");
      return;
    }
    try
    {
      int i = Integer.parseInt(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
      int j = Integer.parseInt(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
      ((aube)paramQQAppInterface.getManager(14)).a(String.valueOf(j), new apue(this, j, i, paramEditText, paramQQAppInterface));
      return;
    }
    catch (NumberFormatException paramQQAppInterface)
    {
      bdqr.a("emotionType", "emotionActionSend", "4", "", "", "", "", "", "", "");
      QLog.e(this.jdField_a_of_type_JavaLangString, 1, "fail to send small_emotion. id is not Int.");
    }
  }
  
  public Drawable b(Context paramContext, float paramFloat)
  {
    paramContext = null;
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null) {}
    do
    {
      for (;;)
      {
        return paramContext;
        try
        {
          Object localObject = new URL("emotion_pic", "fromAIO", a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon));
          paramContext = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          paramContext = BaseApplicationImpl.getApplication().waitAppRuntime(null);
          if ((paramContext instanceof QQAppInterface)) {
            paramContext = (QQAppInterface)paramContext;
          }
          paramContext = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mFailedDrawable = paramContext;
          localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          localURLDrawableOptions.mPlayGifImage = true;
          if (this.jdField_b_of_type_Boolean)
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "getBigDrawable: APNG so loaded use apng image");
            }
            localURLDrawableOptions.mUseApngImage = true;
            localURLDrawableOptions.mPlayGifImage = false;
            localURLDrawableOptions.mMemoryCacheKeySuffix = "useAPNG";
          }
          localURLDrawableOptions.mRequestWidth = this.jdField_b_of_type_Int;
          localURLDrawableOptions.mRequestHeight = this.h;
          localObject = URLDrawable.getDrawable((URL)localObject, localURLDrawableOptions);
          paramContext = (Context)localObject;
          if (((URLDrawable)localObject).getStatus() != 1)
          {
            ((URLDrawable)localObject).setTag(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
            ((URLDrawable)localObject).addHeader("my_uin", this.jdField_b_of_type_JavaLangString);
            ((URLDrawable)localObject).addHeader("emo_big", "true");
            paramContext = (Context)localObject;
            if (QLog.isColorLevel())
            {
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "b.getStatus=" + ((URLDrawable)localObject).getStatus() + " e.epId=" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId + " e.eId=" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
              return localObject;
            }
          }
        }
        catch (MalformedURLException localMalformedURLException) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "getDrawable ,", localMalformedURLException);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apud
 * JD-Core Version:    0.7.0.1
 */