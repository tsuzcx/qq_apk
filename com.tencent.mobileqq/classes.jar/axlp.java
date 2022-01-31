import android.os.Handler;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.theme.ListenTogetherTheme.FloatViewSkin.4;
import com.tencent.qphone.base.util.QLog;

public class axlp
  extends axlt
{
  private static axlp jdField_a_of_type_Axlp;
  private int jdField_a_of_type_Int;
  ajfe jdField_a_of_type_Ajfe = new axlr(this);
  private View jdField_a_of_type_AndroidViewView;
  awnt jdField_a_of_type_Awnt = new axlq(this);
  private baof jdField_a_of_type_Baof = new axls(this);
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString = "";
  private boolean c;
  
  public static axlp a()
  {
    if (jdField_a_of_type_Axlp == null) {}
    try
    {
      if (jdField_a_of_type_Axlp == null)
      {
        jdField_a_of_type_Axlp = new axlp();
        ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).addObserver(jdField_a_of_type_Axlp.jdField_a_of_type_Ajfe);
        ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).addObserver(jdField_a_of_type_Axlp.jdField_a_of_type_Awnt);
      }
      return jdField_a_of_type_Axlp;
    }
    finally {}
  }
  
  public void a()
  {
    baot localbaot = (baot)((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).a(71);
    if (localbaot != null) {
      localbaot.f();
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt > 0)
    {
      this.jdField_b_of_type_Int = paramInt;
      this.jdField_a_of_type_Boolean = true;
      baqs.a.download(null, this.jdField_b_of_type_Int, this.jdField_a_of_type_Baof, false);
    }
    do
    {
      return;
      this.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_Boolean = false;
      a(null);
    } while (this.jdField_a_of_type_AndroidViewView == null);
    ThreadManagerV2.getUIHandlerV2().post(new FloatViewSkin.4(this));
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(View paramView, String paramString, int paramInt)
  {
    if ((paramView == null) || (awnu.b())) {}
    do
    {
      return;
      a();
      this.jdField_a_of_type_AndroidViewView = paramView;
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_b_of_type_JavaLangString = paramString;
      if (this.jdField_a_of_type_Boolean) {
        b(paramView);
      }
    } while (!QLog.isColorLevel());
    QLog.i("FloatViewSkin", 2, "enter uin:" + this.jdField_b_of_type_JavaLangString + "  type:" + this.jdField_a_of_type_Int + " mIsUserSkin:" + this.jdField_a_of_type_Boolean);
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    BaseApplicationImpl.sImageCache.evictAll();
    if (TextUtils.isEmpty(paramString))
    {
      a(paramString);
      this.jdField_a_of_type_Boolean = false;
    }
    for (;;)
    {
      b(this.jdField_a_of_type_AndroidViewView);
      return;
      a(paramString);
      this.jdField_a_of_type_Boolean = true;
      this.c = true;
    }
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Int > 0;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      b(this.jdField_a_of_type_AndroidViewView);
    }
    this.jdField_a_of_type_AndroidViewView = null;
    if (QLog.isColorLevel()) {
      QLog.i("FloatViewSkin", 2, "leave uin:" + this.jdField_b_of_type_JavaLangString + "  type:" + this.jdField_a_of_type_Int);
    }
  }
  
  public void b(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FloatViewSkin", 2, "setMusicBarSkin uin:" + this.jdField_b_of_type_JavaLangString + "  type:" + this.jdField_a_of_type_Int + " mIsUserSkin:" + this.jdField_a_of_type_Boolean);
    }
    QLog.i("FloatViewSkin", 1, "setMusicBarSkin mIsShowSkin:" + this.c + "  mIsUserSkin:" + this.jdField_a_of_type_Boolean);
    if ((paramView == null) || (!this.c)) {
      return;
    }
    if (awnu.b()) {}
    for (this.jdField_b_of_type_Boolean = false;; this.jdField_b_of_type_Boolean = true)
    {
      paramView = paramView.getRootView();
      a(paramView, 2131304917, 2130843906, "qq_aio_listentogether_lyrics_music_point@3x.png");
      b(paramView, 2131304886, 2130843903, "qq_aio_listentogether_lyrics_music_bg@3x.png");
      b(paramView, 2131304923, 2130843905, "qq_aio_listentogether_lyrics_music_dot@3x.png");
      b(paramView, 2131298717, 2130843904, "qq_aio_listentogether_lyrics_music_close@3x.png");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axlp
 * JD-Core Version:    0.7.0.1
 */