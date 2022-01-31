import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayDeque;

public class balm
  extends axwe
{
  private static ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(0);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  balq jdField_a_of_type_Balq = new balq(this);
  URLDrawableDownListener.Adapter jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter = new baln(this);
  private ArrayDeque<balo> jdField_a_of_type_JavaUtilArrayDeque = new ArrayDeque();
  private boolean jdField_a_of_type_Boolean = true;
  
  public balm(ImageView paramImageView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
    if ((paramImageView instanceof URLImageView)) {
      ((URLImageView)paramImageView).setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter);
    }
  }
  
  private Drawable a()
  {
    Object localObject = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    Drawable localDrawable = this.jdField_a_of_type_AndroidWidgetImageView.getDrawable();
    if (localDrawable != null)
    {
      localObject = localDrawable;
      if ((localDrawable instanceof URLDrawable)) {
        localObject = ((URLDrawable)localDrawable).getCurrDrawable();
      }
      return localObject;
    }
    return localObject;
  }
  
  private void b()
  {
    Object localObject = (balo)this.jdField_a_of_type_JavaUtilArrayDeque.poll();
    if (localObject == null) {
      this.jdField_a_of_type_Boolean = true;
    }
    do
    {
      return;
      this.jdField_a_of_type_Boolean = false;
      localObject = ((balo)localObject).a(a());
      if (((URLDrawable)localObject).getStatus() == 1)
      {
        b();
        return;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    } while ((this.jdField_a_of_type_AndroidWidgetImageView instanceof URLImageView));
    ((URLDrawable)localObject).setURLDrawableListener(this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilArrayDeque.clear();
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(balo parambalo)
  {
    this.jdField_a_of_type_JavaUtilArrayDeque.add(parambalo);
    if (this.jdField_a_of_type_Boolean) {
      b();
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    a(new balp(paramString, paramInt));
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.e("ApngQueuePlayer", 1, "onLoadFialed: ", paramThrowable);
    b();
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = ((ApngDrawable)paramURLDrawable.getCurrDrawable()).getImage();
    if (paramURLDrawable.mFrameCount <= 1)
    {
      b();
      return;
    }
    if ((paramURLDrawable.apngLoop > 0) && (paramURLDrawable.currentApngLoop >= paramURLDrawable.apngLoop)) {
      paramURLDrawable.replay();
    }
    if (paramURLDrawable.apngLoop != 0)
    {
      this.jdField_a_of_type_Balq.a(paramURLDrawable);
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     balm
 * JD-Core Version:    0.7.0.1
 */