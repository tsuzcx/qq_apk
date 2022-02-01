import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;

public class asxn
{
  private static Method jdField_a_of_type_JavaLangReflectMethod;
  private int jdField_a_of_type_Int = 0;
  private final View jdField_a_of_type_AndroidViewView;
  private final ImageView jdField_a_of_type_AndroidWidgetImageView;
  private final TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString = "";
  private final View jdField_b_of_type_AndroidViewView;
  private final TextView jdField_b_of_type_AndroidWidgetTextView;
  private final TextView c;
  
  public asxn(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131375463);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131375465));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131375901);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131375900));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131375903));
    this.c = ((TextView)paramView.findViewById(2131375902));
    try
    {
      ImageLoader.getInstance().downloadImageOnly("https://sola.gtimg.cn/aoi/sola/20200526111437_Jxz3xRir1X.png", null);
      return;
    }
    catch (Throwable paramView)
    {
      QLog.w("ExtendEmptyViewDirector", 1, "init: failed to download image", paramView);
    }
  }
  
  @Nullable
  private static Method a(ImageView paramImageView)
  {
    if (jdField_a_of_type_JavaLangReflectMethod != null) {
      return jdField_a_of_type_JavaLangReflectMethod;
    }
    try
    {
      jdField_a_of_type_JavaLangReflectMethod = paramImageView.getClass().getMethod("setAsyncImage", new Class[] { String.class });
      return jdField_a_of_type_JavaLangReflectMethod;
    }
    catch (Throwable paramImageView)
    {
      for (;;)
      {
        QLog.w("ExtendEmptyViewDirector", 1, "getSetAsyncImageMethod: failed", paramImageView);
      }
    }
  }
  
  private void a(ImageView paramImageView, @NonNull String paramString)
  {
    if (this.jdField_a_of_type_JavaLangString.equals(paramString)) {}
    Method localMethod;
    do
    {
      return;
      localMethod = a(paramImageView);
    } while (localMethod == null);
    try
    {
      localMethod.invoke(paramImageView, new Object[] { paramString });
      this.jdField_a_of_type_JavaLangString = paramString;
      return;
    }
    catch (Throwable paramImageView)
    {
      QLog.w("ExtendEmptyViewDirector", 1, "setAsyncImage: failed", paramImageView);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Int == 0) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_Int = 0;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Int == 1) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131716833);
    this.jdField_a_of_type_Int = 1;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Int == 2) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setText("刷新失败，请下拉重试");
    this.jdField_a_of_type_Int = 2;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Int == 3) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setText("什么都没找到哦");
    this.c.setText("没有搜索到相关内容");
    a(this.jdField_a_of_type_AndroidWidgetImageView, "https://sola.gtimg.cn/aoi/sola/20200508145045_234LrOf7V4.png");
    this.jdField_a_of_type_Int = 3;
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Int == 4) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setText("无法连接到互联网");
    this.c.setText("请关闭飞行模式或检查设备的网络设置");
    a(this.jdField_a_of_type_AndroidWidgetImageView, "https://sola.gtimg.cn/aoi/sola/20200526111437_Jxz3xRir1X.png");
    this.jdField_a_of_type_Int = 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asxn
 * JD-Core Version:    0.7.0.1
 */