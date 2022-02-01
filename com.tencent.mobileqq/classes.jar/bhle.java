import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.transfile.URLDrawableHelper.Adapter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayDeque;

public class bhle
  extends URLDrawableHelper.Adapter
{
  private static ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(0);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  bhli jdField_a_of_type_Bhli = new bhli(this);
  URLDrawableDownListener.Adapter jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter = new bhlf(this);
  private ArrayDeque<bhlg> jdField_a_of_type_JavaUtilArrayDeque = new ArrayDeque();
  private boolean jdField_a_of_type_Boolean = true;
  
  public bhle(ImageView paramImageView)
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
    Object localObject = (bhlg)this.jdField_a_of_type_JavaUtilArrayDeque.poll();
    if (localObject == null) {
      this.jdField_a_of_type_Boolean = true;
    }
    do
    {
      return;
      this.jdField_a_of_type_Boolean = false;
      localObject = ((bhlg)localObject).a(a());
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
  
  public void a(bhlg parambhlg)
  {
    this.jdField_a_of_type_JavaUtilArrayDeque.add(parambhlg);
    if (this.jdField_a_of_type_Boolean) {
      b();
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    a(new bhlh(paramString, paramInt));
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
      this.jdField_a_of_type_Bhli.a(paramURLDrawable);
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhle
 * JD-Core Version:    0.7.0.1
 */