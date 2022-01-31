import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class aoab
  implements URLDrawable.URLDrawableListener
{
  aoab(anzz paramanzz) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    this.a.jdField_a_of_type_JavaUtilArrayList.remove(paramURLDrawable);
    if (QLog.isColorLevel())
    {
      paramURLDrawable = paramURLDrawable.getTag();
      if ((paramURLDrawable != null) && ((paramURLDrawable instanceof Emoticon)))
      {
        paramURLDrawable = (Emoticon)paramURLDrawable;
        QLog.d("EmotionKeywordAdapter", 2, "firstScreenListener onLoadCanceled eId = " + paramURLDrawable.eId);
      }
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    this.a.jdField_a_of_type_JavaUtilArrayList.remove(paramURLDrawable);
    if (QLog.isColorLevel())
    {
      paramURLDrawable = paramURLDrawable.getTag();
      if ((paramURLDrawable != null) && ((paramURLDrawable instanceof Emoticon)))
      {
        paramURLDrawable = (Emoticon)paramURLDrawable;
        QLog.d("EmotionKeywordAdapter", 2, "firstScreenListener onLoadFialed eId = " + paramURLDrawable.eId);
      }
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    this.a.jdField_a_of_type_JavaUtilArrayList.remove(paramURLDrawable);
    paramURLDrawable = paramURLDrawable.getTag();
    if ((paramURLDrawable != null) && ((paramURLDrawable instanceof Emoticon)))
    {
      paramURLDrawable = (Emoticon)paramURLDrawable;
      if (!this.a.jdField_a_of_type_JavaUtilList.contains(paramURLDrawable)) {
        this.a.jdField_a_of_type_JavaUtilList.add(paramURLDrawable);
      }
      this.a.a();
      if (QLog.isColorLevel()) {
        QLog.d("EmotionKeywordAdapter", 2, "firstScreenListener downloadSucess eId = " + paramURLDrawable.eId);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoab
 * JD-Core Version:    0.7.0.1
 */