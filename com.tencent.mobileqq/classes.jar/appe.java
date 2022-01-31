import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.RejectedExecutionException;

class appe
  implements URLDrawable.URLDrawableListener
{
  appe(apox paramapox) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if ((paramThrowable instanceof RejectedExecutionException)) {
      if (QLog.isColorLevel()) {
        QLog.i("BigEmotionDownloadedAdapter", 2, "arg0.getConstantState() = " + paramURLDrawable.getConstantState());
      }
    }
    label41:
    int i;
    do
    {
      do
      {
        do
        {
          break label41;
          do
          {
            return;
          } while (paramURLDrawable == null);
          paramThrowable = paramURLDrawable.getFileInLocal();
          if ((paramThrowable != null) && (paramThrowable.exists())) {
            paramThrowable.delete();
          }
          paramThrowable = paramURLDrawable.getTag();
        } while (!(paramThrowable instanceof Integer));
        i = ((Integer)paramThrowable).intValue();
      } while (i >= 3);
      i += 1;
      paramURLDrawable.setTag(Integer.valueOf(i));
      paramURLDrawable.restartDownload();
    } while (!QLog.isColorLevel());
    QLog.i("BigEmotionDownloadedAdapter", 2, "download recomment comic pic , try count = " + i);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     appe
 * JD-Core Version:    0.7.0.1
 */